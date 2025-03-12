export type E_UserRole = 'propertyOwner' | 'admin';

export interface I_User {
    id: string;
    firstName: string;
    lastName: string;
    fullName: string;
    username: string;
    role: E_UserRole;
    avatar: string;
    password: string;
  }