import React, { useState } from 'react';
import { User } from '../types';
import { API_USUARIOS } from '../services/api';

interface LoginScreenProps {
  onLogin: (user: User) => void;
  onCadastro: () => void;
}

export default function LoginScreen({ onLogin, onCadastro }: LoginScreenProps) {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [erro, setErro] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSubmit = async () => {
    setErro('');
    setLoading(true);

    try {
      const response = await fetch(`${API_USUARIOS}/v1/usuarios/autenticacao`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, senha })
      });

      if (!response.ok) {
        throw new Error('Credenciais inválidas');
      }

      const data = await response.json();
      onLogin({ token: data.token, tipo: data.tipo, id: data.id });
    } catch (err) {
      setErro('Erro ao fazer login. Verifique suas credenciais.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh' }}>
      <div style={{ backgroundColor: 'white', padding: '40px', borderRadius: '8px', boxShadow: '0 2px 10px rgba(0,0,0,0.1)', width: '400px' }}>
        <h1 style={{ textAlign: 'center', marginBottom: '30px', color: '#333' }}>Hotel Booking</h1>
        <div>
          <div style={{ marginBottom: '20px' }}>
            <label style={{ display: 'block', marginBottom: '8px', color: '#555' }}>Email</label>
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              style={{ width: '100%', padding: '10px', border: '1px solid #ddd', borderRadius: '4px' }}
            />
          </div>
          <div style={{ marginBottom: '20px' }}>
            <label style={{ display: 'block', marginBottom: '8px', color: '#555' }}>Senha</label>
            <input
              type="password"
              value={senha}
              onChange={(e) => setSenha(e.target.value)}
              onKeyPress={(e) => e.key === 'Enter' && handleSubmit()}
              style={{ width: '100%', padding: '10px', border: '1px solid #ddd', borderRadius: '4px' }}
            />
          </div>
          {erro && <div style={{ color: 'red', marginBottom: '15px', fontSize: '14px' }}>{erro}</div>}
          <button
            onClick={handleSubmit}
            disabled={loading}
            style={{ width: '100%', padding: '12px', backgroundColor: '#007bff', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontSize: '16px' }}
          >
            {loading ? 'Entrando...' : 'Entrar'}
          </button>
        </div>
        <div style={{ textAlign: 'center', marginTop: '20px' }}>
          <button
            onClick={onCadastro}
            style={{ background: 'none', border: 'none', color: '#007bff', cursor: 'pointer', textDecoration: 'underline' }}
          >
            Não tem conta? Cadastre-se
          </button>
        </div>
      </div>
    </div>
  );
}