import React, { useState, useEffect } from 'react';
import { DashboardData, Avaliacao } from '../types';
import { API_HOTEIS } from '../services/api';

interface DashboardGerenteProps {
  token: string;
}

function MetricCard({ title, value, color }: { title: string; value: string; color: string }) {
  return (
    <div style={{ backgroundColor: color, color: 'white', padding: '30px', borderRadius: '8px', textAlign: 'center', boxShadow: '0 2px 4px rgba(0,0,0,0.1)' }}>
      <h3 style={{ margin: '0 0 10px 0', fontSize: '16px', opacity: 0.9 }}>{title}</h3>
      <p style={{ margin: 0, fontSize: '28px', fontWeight: 'bold' }}>{value}</p>
    </div>
  );
}

export default function DashboardGerente({ token }: DashboardGerenteProps) {
  const [dashboard, setDashboard] = useState<DashboardData | null>(null);
  const [reclamacoes, setReclamacoes] = useState<Avaliacao[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [dashRes, avalRes] = await Promise.all([
          fetch(`${API_HOTEIS}/v1/dashboard`, {
            headers: { 'Authorization': `Bearer ${token}` }
          }),
          fetch(`${API_HOTEIS}/v1/avaliacoes`, {
            headers: { 'Authorization': `Bearer ${token}` }
          })
        ]);

        if (dashRes.ok) {
          const dashData = await dashRes.json();
          setDashboard(dashData);
        }

        if (avalRes.ok) {
          const avalData = await avalRes.json();
          const reclamacoesFiltered = avalData.filter((a: Avaliacao) => a.nota <= 2);
          setReclamacoes(reclamacoesFiltered);
        }
      } catch (err) {
        console.error('Erro ao carregar dashboard:', err);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, [token]);

  if (loading) {
    return <div style={{ textAlign: 'center', padding: '50px' }}>Carregando dashboard...</div>;
  }

  return (
    <div>
      <h2 style={{ marginBottom: '30px' }}>Dashboard Gerencial</h2>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '20px', marginBottom: '40px' }}>
        <MetricCard title="Taxa de Ocupação" value={`${dashboard?.taxaOcupacao || 0}%`} color="#28a745" />
        <MetricCard title="Receita Total" value={`R$ ${dashboard?.receitaTotal?.toLocaleString('pt-BR') || 0}`} color="#007bff" />
        <MetricCard title="Taxa de Cancelamento" value={`${dashboard?.taxaCancelamento || 0}%`} color="#dc3545" />
        <MetricCard title="Não Comparecimento" value={`${dashboard?.taxaNaoComparecimento || 0}%`} color="#ffc107" />
        <MetricCard title="Duração Média Estadia" value={`${dashboard?.duracaoMediaEstadia || 0} dias`} color="#17a2b8" />
      </div>
      
      <h3 style={{ marginBottom: '20px' }}>Reclamações Recentes</h3>
      <div style={{ backgroundColor: 'white', borderRadius: '8px', padding: '20px', boxShadow: '0 2px 4px rgba(0,0,0,0.1)' }}>
        {reclamacoes.length === 0 ? (
          <p>Nenhuma reclamação encontrada.</p>
        ) : (
          reclamacoes.map((rec, idx) => (
            <div key={idx} style={{ borderBottom: idx < reclamacoes.length - 1 ? '1px solid #eee' : 'none', padding: '15px 0' }}>
              <div style={{ display: 'flex', alignItems: 'center', marginBottom: '5px' }}>
                <span style={{ fontWeight: 'bold', marginRight: '10px' }}>Nota: {rec.nota}</span>
                <span style={{ color: '#666', fontSize: '14px' }}>{new Date(rec.data).toLocaleDateString('pt-BR')}</span>
              </div>
              <p style={{ margin: 0, color: '#555' }}>{rec.comentario}</p>
            </div>
          ))
        )}
      </div>
    </div>
  );
}