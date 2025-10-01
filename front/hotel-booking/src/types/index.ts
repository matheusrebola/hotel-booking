export type UserType = 'GERENTE' | 'COMUM';

export interface User {
  token: string;
  tipo: UserType;
  id: string;
}

export interface Hotel {
  id: string;
  nome: string;
  cidade: string;
  estado: string;
  pais: string;
  nota: number;
  tipoQuarto: string;
  capacidade: number;
  preco: number;
  foto: string;
}

export interface Comodidade {
  nome: string;
}

export interface Avaliacao {
  nota: number;
  comentario: string;
  data: string;
}

export interface DashboardData {
  taxaOcupacao: number;
  receitaTotal: number;
  taxaCancelamento: number;
  taxaNaoComparecimento: number;
  duracaoMediaEstadia: number;
}