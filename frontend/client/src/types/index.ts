export interface User {
  firstName: string;
  lastName: string;
  username: string;
  role?: 'tenant' | 'owner';
}

export interface PropertyOwner extends User {
  role: 'owner';
}

export interface House {
  id: string;
  title: string;
  description: string;
  amenities: string[];
  availability: boolean;
  price: number;
  zipcode: string;
  street: string;
  state: string;
  images: string[];
  owner: PropertyOwner;
}

export interface Booking {
  id: string;
  houseId: string;
  house: House;
  tenant: User;
  startDate: string;
  endDate: string;
  status: 'pending' | 'approved' | 'rejected' | 'completed';
  createdAt: string;
}

export interface AuthState {
  user: User | null;
  isAuthenticated: boolean;
  expiresAt: string | null;
  login: (username: string, password: string) => void;
  logout: () => void;
  checkAuth: () => void;
}