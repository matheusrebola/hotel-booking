import React, { useState } from 'react';
import { API_USUARIOS } from '../services/api';

interface CadastroScreenProps {
  onVoltar: () => void;
}

export default function CadastroScreen({ onVoltar }: CadastroScreenProps) {
  const [formData, setFormData] = useState({
    nome: '',
    email: '',
    senha: '',
    telefone: '',
    dataNascimento: '',
    preferenciaViagem: 'LAZER'
  });
  const [sucesso, setSucesso] = useState(false);
  const [erro, setErro] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSubmit = async () => {
    setErro('');
    setLoading(true);

    try {
      const response = await fetch(`${API_USUARIOS}/v1/cadastro`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData)
      });

      if (!response.ok) {
        throw new Error('Erro ao cadastrar');
      }

      setSucesso(true);
      setTimeout(() => onVoltar(), 2000);
    } catch (err) {
      setErro('Erro ao cadastrar. Tente novamente.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh', padding: '20px' }}>
      <div style={{ backgroundColor: 'white', padding: '40px', borderRadius: '8px', boxShadow: '0 2px 10px rgba(0,0,0,0.1)', width: '500px' }}>
        <h1 style={{ textAlign: 'center', marginBottom: '30px', color: '#333' }}>Cadastro</h1>
        {sucesso ? (
          <div style={{ textAlign: 'center', color: 'green', fontSize: '18px' }}>
            Cadastro realizado com sucesso! Redirecionando...
          </div>
        ) : (
          <div>
            <div style={{ marginBottom: '15px' }}>
              <label style={{ display: 'block', marginBottom: '5px', color: '#555' }}>Nome</label>
              <input
                type="text"
                value={formData.nome}
                onChange={(e) => setFormData({ ...formData, nome: e.target.value })}
                style={{ width: '100%', padding: '10px', border: '1px solid #ddd', borderRadius: '4px' }}
              />
            </div>
            <div style={{ marginBottom: '15px' }}>
              <label style={{ display: 'block', marginBottom: '5px', color: '#555' }}>Email</label>
              <input
                type="email"
                value={formData.email}
                onChange={(e) => setFormData({ ...formData, email: e.target.value })}
                style={{ width: '100%', padding: '10px', border: '1px solid #ddd', borderRadius: '4px' }}
              />
            </div>
            <div style={{ marginBottom: '15px' }}>
              <label style={{ display: 'block', marginBottom: '5px', color: '#555' }}>Senha</label>
              <input
                type="password"
                value={formData.senha}
                onChange={(e) => setFormData({ ...formData, senha: e.target.value })}
                style={{ width: '100%', padding: '10px', border: '1px solid #ddd', borderRadius: '4px' }}
              />
            </div>
            <div style={{ marginBottom: '15px' }}>
              <label style={{ display: 'block', marginBottom: '5px', color: '#555' }}>Telefone</label>
              <input
                type="tel"
                value={formData.telefone}
                onChange={(e) => setFormData({ ...formData, telefone: e.target.value })}
                style={{ width: '100%', padding: '10px', border: '1px solid #ddd', borderRadius: '4px' }}
              />
            </div>
            <div style={{ marginBottom: '15px' }}>
              <label style={{ display: 'block', marginBottom: '5px', color: '#555' }}>Data de Nascimento</label>
              <input
                type="date"
                value={formData.dataNascimento}
                onChange={(e) => setFormData({ ...formData, dataNascimento: e.target.value })}
                style={{ width: '100%', padding: '10px', border: '1px solid #ddd', borderRadius: '4px' }}
              />
            </div>
            <div style={{ marginBottom: '20px' }}>
              <label style={{ display: 'block', marginBottom: '5px', color: '#555' }}>Preferência de Viagem</label>
              <select
                value={formData.preferenciaViagem}
                onChange={(e) => setFormData({ ...formData, preferenciaViagem: e.target.value })}
                style={{ width: '100%', padding: '10px', border: '1px solid #ddd', borderRadius: '4px' }}
              >
                <option value="LAZER">Lazer</option>
                <option value="NEGOCIOS">Negócios</option>
                <option value="AVENTURA">Aventura</option>
                <option value="ROMANTICO">Romântico</option>
              </select>
            </div>
            {erro && <div style={{ color: 'red', marginBottom: '15px', fontSize: '14px' }}>{erro}</div>}
            <button
              onClick={handleSubmit}
              disabled={loading}
              style={{ width: '100%', padding: '12px', backgroundColor: '#28a745', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontSize: '16px', marginBottom: '10px' }}
            >
              {loading ? 'Cadastrando...' : 'Cadastrar'}
            </button>
            <button
              onClick={onVoltar}
              style={{ width: '100%', padding: '12px', backgroundColor: '#6c757d', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontSize: '16px' }}
            >
              Voltar
            </button>
          </div>
        )}
      </div>
    </div>
  );
}