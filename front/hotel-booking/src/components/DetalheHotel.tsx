import React, { useState, useEffect } from 'react';
import { Star } from 'lucide-react';
import { Hotel, Comodidade, Avaliacao } from '../types';
import { API_HOTEIS } from '../services/api';

interface DetalheHotelProps {
  hotelId: string;
  token: string;
  userId: string;
  onVoltar: () => void;
}

export default function DetalheHotel({ hotelId, token, userId, onVoltar }: DetalheHotelProps) {
  const [hotel, setHotel] = useState<Hotel | null>(null);
  const [comodidades, setComodidades] = useState<Comodidade[]>([]);
  const [avaliacoes, setAvaliacoes] = useState<Avaliacao[]>([]);
  const [loading, setLoading] = useState(true);
  const [reservando, setReservando] = useState(false);
  const [mensagem, setMensagem] = useState('');

  useEffect(() => {
    const fetchDetalhes = async () => {
      try {
        const [hotelRes, comodRes, avalRes] = await Promise.all([
          fetch(`${API_HOTEIS}/v1/hoteis/${hotelId}`, {
            headers: { 'Authorization': `Bearer ${token}` }
          }),
          fetch(`${API_HOTEIS}/v1/hoteis/${hotelId}/comodidades`, {
            headers: { 'Authorization': `Bearer ${token}` }
          }),
          fetch(`${API_HOTEIS}/v1/hoteis/${hotelId}/avaliacoes`, {
            headers: { 'Authorization': `Bearer ${token}` }
          })
        ]);

        if (hotelRes.ok) setHotel(await hotelRes.json());
        if (comodRes.ok) setComodidades(await comodRes.json());
        if (avalRes.ok) setAvaliacoes(await avalRes.json());
      } catch (err) {
        console.error('Erro ao carregar detalhes:', err);
      } finally {
        setLoading(false);
      }
    };

    fetchDetalhes();
  }, [hotelId, token]);

  const handleReservar = async () => {
    setReservando(true);
    setMensagem('');

    try {
      const response = await fetch(`${API_HOTEIS}/v1/reserva`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify({ hotelId, usuarioId: userId })
      });

      if (response.ok) {
        setMensagem('Reserva realizada com sucesso!');
      } else {
        setMensagem('Erro ao realizar reserva.');
      }
    } catch (err) {
      setMensagem('Erro ao realizar reserva.');
    } finally {
      setReservando(false);
    }
  };

  if (loading) {
    return <div style={{ textAlign: 'center', padding: '50px' }}>Carregando...</div>;
  }

  if (!hotel) {
    return <div>Hotel não encontrado</div>;
  }

  return (
    <div>
      <button
        onClick={onVoltar}
        style={{ padding: '10px 20px', backgroundColor: '#6c757d', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', marginBottom: '20px' }}
      >
        ← Voltar
      </button>
      
      <div style={{ backgroundColor: 'white', borderRadius: '8px', padding: '30px', boxShadow: '0 2px 4px rgba(0,0,0,0.1)' }}>
        <img src={hotel.foto} alt={hotel.nome} style={{ width: '100%', maxHeight: '400px', objectFit: 'cover', borderRadius: '8px', marginBottom: '20px' }} />
        
        <h2 style={{ marginBottom: '10px' }}>{hotel.nome}</h2>
        <p style={{ color: '#666', marginBottom: '20px' }}>
          {hotel.cidade}, {hotel.estado} - {hotel.pais}
        </p>
        
        <div style={{ display: 'flex', alignItems: 'center', marginBottom: '20px' }}>
          {[...Array(5)].map((_, i) => (
            <Star key={i} size={20} fill={i < hotel.nota ? '#ffc107' : 'none'} color="#ffc107" />
          ))}
          <span style={{ marginLeft: '10px', fontSize: '16px' }}>({hotel.nota})</span>
        </div>

        <div style={{ marginBottom: '30px' }}>
          <p><strong>Tipo de Quarto:</strong> {hotel.tipoQuarto}</p>
          <p><strong>Capacidade:</strong> {hotel.capacidade} pessoas</p>
          <p style={{ fontSize: '24px', fontWeight: 'bold', color: '#007bff' }}>
            R$ {hotel.preco.toLocaleString('pt-BR')}/noite
          </p>
        </div>

        <h3>Comodidades</h3>
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(150px, 1fr))', gap: '10px', marginBottom: '30px' }}>
          {comodidades.map((com, idx) => (
            <div key={idx} style={{ padding: '10px', backgroundColor: '#f8f9fa', borderRadius: '4px' }}>
              {com.nome}
            </div>
          ))}
        </div>

        <h3>Avaliações</h3>
        <div style={{ marginBottom: '30px' }}>
          {avaliacoes.length === 0 ? (
            <p>Nenhuma avaliação ainda.</p>
          ) : (
            avaliacoes.map((aval, idx) => (
              <div key={idx} style={{ borderBottom: idx < avaliacoes.length - 1 ? '1px solid #eee' : 'none', padding: '15px 0' }}>
                <div style={{ display: 'flex', alignItems: 'center', marginBottom: '5px' }}>
                  <div style={{ display: 'flex', marginRight: '10px' }}>
                    {[...Array(5)].map((_, i) => (
                      <Star key={i} size={14} fill={i < aval.nota ? '#ffc107' : 'none'} color="#ffc107" />
                    ))}
                  </div>
                  <span style={{ color: '#666', fontSize: '14px' }}>{new Date(aval.data).toLocaleDateString('pt-BR')}</span>
                </div>
                <p style={{ margin: 0, color: '#555' }}>{aval.comentario}</p>
              </div>
            ))
          )}
        </div>

        {mensagem && (
          <div style={{ padding: '15px', backgroundColor: mensagem.includes('sucesso') ? '#d4edda' : '#f8d7da', color: mensagem.includes('sucesso') ? '#155724' : '#721c24', borderRadius: '4px', marginBottom: '20px' }}>
            {mensagem}
          </div>
        )}

        <button
          onClick={handleReservar}
          disabled={reservando}
          style={{ width: '100%', padding: '15px', backgroundColor: '#28a745', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontSize: '18px', fontWeight: 'bold' }}
        >
          {reservando ? 'Reservando...' : 'Reservar Agora'}
        </button>
      </div>
    </div>
  );
}