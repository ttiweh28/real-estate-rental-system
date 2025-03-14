import { create } from 'zustand';
import { persist } from 'zustand/middleware';
import { AuthState } from '../types';
import { mockUser } from '../data/mockData';

export const useAuthStore = create<AuthState>()(
  persist(
    (set) => ({
      user: null,
      isAuthenticated: false,
      login: (username: string, password: string) => {
        // Mock login - in real app this would make an API call
        if (username && password) {
          // Simulate token expiration after 24 hours
          const expiresAt = new Date();
          expiresAt.setHours(expiresAt.getHours() + 24);
          
          set({ 
            user: mockUser, 
            isAuthenticated: true,
            expiresAt: expiresAt.toISOString()
          });
        }
      },
      logout: () => {
        set({ 
          user: null, 
          isAuthenticated: false,
          expiresAt: null 
        });
      },
      checkAuth: () => {
        set((state) => {
          if (!state.expiresAt) return state;
          
          const isExpired = new Date(state.expiresAt) < new Date();
          if (isExpired) {
            return { 
              user: null, 
              isAuthenticated: false,
              expiresAt: null 
            };
          }
          return state;
        });
      }
    }),
    {
      name: 'auth-storage',
      // Only persist these fields
      partialize: (state) => ({
        user: state.user,
        isAuthenticated: state.isAuthenticated,
        expiresAt: state.expiresAt
      })
    }
  )
);