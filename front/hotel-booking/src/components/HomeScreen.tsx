import React from 'react';
import { User } from '../types';
import DashboardGerente from './DashboardGerente';
import ListaHoteis from './ListaHoteis';

interface HomeScreenProps {
  user: User;
  onLogout: () => void;
  selectedHotel: string | null;
  setSelectedHotel: (id: string | null) => void;
}

export default function HomeScreen({ user, onLogout, selectedHotel, setSelectedHotel }: HomeScreenProps) {
  return (
    <div>
      <header style={{ backgroundColor: '#007bff', color: 'white', padding: '15px 30px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <h1 style={{ margin: 0 }}>Hotel Booking</h1>
        <button
          onClick={onLogout}
          style={{ padding: '8px 20px', backgroundColor: 'white', color: '#007bff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Sair
        </button>
      </header>
      <main style={{ padding: '30px' }}>
        {user.tipo === 'GERENTE' ? (
          <DashboardGerente token={user.token} />
        ) : (
          <ListaHoteis token={user.token} userId={user.id} selectedHotel={selectedHotel} setSelectedHotel={setSelectedHotel} />
        )}
      </main>
    </div>
  );
}