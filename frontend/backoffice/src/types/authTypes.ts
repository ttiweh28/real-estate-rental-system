export type E_UserRole = 'ROLE_PROPERTIES_OWNER' | 'ROLE_ADMIN';

export interface I_Address {
  street: string;
  city: string;
  state: string;
  zipCode: string;
  country: string;
}

export interface I_User {
  id: number;
  firstName: string;
  lastName: string;
  fullName?: string;
  userName: string;
  email: string;
  phoneNumber: string;
  photo: string;
  role: E_UserRole;
  address: I_Address;
  password?: string;
}