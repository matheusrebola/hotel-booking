import React, { useState, useEffect } from 'react';
import { Star } from 'lucide-react';
import { Hotel } from '../types';
import { API_HOTEIS } from '../services/api';
import DetalheHotel from './DetalheHotel';

interface ListaHoteisProps {
  token: string;
  userId: string;
  selectedHotel: string | null;
  setSelectedHotel: (id: string | null) => void;
}

export default function ListaHoteis({ token, userId, selectedHotel, setSelectedHotel }: ListaHoteisProps) {
  const [hoteis, setHoteis] = useState<Hotel[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchHoteis = async () => {
      try {
        const response = await fetch(`${API_HOTEIS}/v1/hoteis`, {
          headers: { 'Authorization': `Bearer ${token}` }
        });

        if (response.ok) {
          const data = await response.json();
          setHoteis(data);
        }
      } catch (err) {
        console.error('Erro ao carregar hotéis:', err);
      } finally {
        setLoading(false);
      }
    };

    fetchHoteis();
  }, [token]);

  if (loading) {
    return <div style={{ textAlign: 'center', padding: '50px' }}>Carregando hotéis...</div>;
  }

  if (selectedHotel) {
    return <DetalheHotel hotelId={selectedHotel} token={token} userId={userId} onVoltar={() => setSelectedHotel(null)} />;
  }

  return (
    <div>
      <h2 style={{ marginBottom: '30px' }}>Hotéis Disponíveis</h2>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))', gap: '20px' }}>
        {hoteis.map((hotel) => (
          <div
            key={hotel.id}
            onClick={() => setSelectedHotel(hotel.id)}
            style={{ backgroundColor: 'white', borderRadius: '8px', overflow: 'hidden', boxShadow: '0 2px 4px rgba(0,0,0,0.1)', cursor: 'pointer', transition: 'transform 0.2s' }}
            onMouseEnter={(e) => e.currentTarget.style.transform = 'scale(1.02)'}
            onMouseLeave={(e) => e.currentTarget.style.transform = 'scale(1)'}
          >
            <img src={hotel.foto} alt={hotel.nome} style={{ width: '100%', height: '200px', objectFit: 'cover' }} />
            <div style={{ padding: '15px' }}>
              <h3 style={{ margin: '0 0 10px 0', fontSize: '18px' }}>{hotel.nome}</h3>
              <p style={{ margin: '0 0 5px 0', color: '#666', fontSize: '14px' }}>
                {hotel.cidade}, {hotel.estado} - {hotel.pais}
              </p>
              <div style={{ display: 'flex', alignItems: 'center', marginBottom: '10px' }}>
                {[...Array(5)].map((_, i) => (
                  <Star key={i} size={16} fill={i < hotel.nota ? '#ffc107' : 'none'} color="#ffc107" />
                ))}
                <span style={{ marginLeft: '5px', fontSize: '14px', color: '#666' }}>({hotel.nota})</span>
              </div>
              <p style={{ margin: '0 0 5px 0', fontSize: '14px' }}>
                <strong>Quarto:</strong> {hotel.tipoQuarto} | <strong>Capacidade:</strong> {hotel.capacidade}
              </p>
              <p style={{ margin: 0, fontSize: '18px', fontWeight: 'bold', color: '#007bff' }}>
                R$ {hotel.preco.toLocaleString('pt-BR')}/noite
              </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}