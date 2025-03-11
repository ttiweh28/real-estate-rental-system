import { AuthProvider } from 'react-admin';

const authProvider: AuthProvider = {
  login: ({ username, password }) => {
    localStorage.setItem('auth', 'true');
    return Promise.resolve();
  },
  logout: () => {
    localStorage.removeItem('auth');
    return Promise.resolve();
  },
  checkAuth: () => {
    return localStorage.getItem('auth') ? Promise.resolve() : Promise.reject();
  },
  checkError: () => {
    return Promise.resolve();
  },
  getPermissions: () => {
    return Promise.resolve();
  },
  getIdentity: () => {
    try {
      return Promise.resolve({
        id: 'user123',
        fullName: 'Mock User',
        avatar: 'https://example.com/avatar.jpg',
      });
    } catch (error) {
      return Promise.reject(error);
    }
  },
};

export default authProvider;