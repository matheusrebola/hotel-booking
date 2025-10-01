import React, { useState, useEffect } from 'react';
import { User } from './types';
import LoginScreen from './components/LoginScreen';
import CadastroScreen from './components/CadastroScreen';
import HomeScreen from './components/HomeScreen';

export default function App() {
  const [screen, setScreen] = useState<'login' | 'cadastro' | 'home'>('login');
  const [user, setUser] = useState<User | null>(null);
  const [selectedHotel, setSelectedHotel] = useState<string | null>(null);

  useEffect(() => {
    const savedUser = localStorage.getItem('user');
    if (savedUser) {
      setUser(JSON.parse(savedUser));
      setScreen('home');
    }
  }, []);

  const handleLogin = (userData: User) => {
    setUser(userData);
    localStorage.setItem('user', JSON.stringify(userData));
    setScreen('home');
  };

  const handleLogout = () => {
    setUser(null);
    localStorage.removeItem('user');
    setScreen('login');
  };

  return (
    <div style={{ minHeight: '100vh', backgroundColor: '#f5f5f5' }}>
      {screen === 'login' && <LoginScreen onLogin={handleLogin} onCadastro={() => setScreen('cadastro')} />}
      {screen === 'cadastro' && <CadastroScreen onVoltar={() => setScreen('login')} />}
      {screen === 'home' && user && (
        <HomeScreen 
          user={user} 
          onLogout={handleLogout}
          selectedHotel={selectedHotel}
          setSelectedHotel={setSelectedHotel}
        />
      )}
    </div>
  );
}