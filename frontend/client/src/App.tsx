import React, { useEffect } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import HouseDetail from './pages/HouseDetail';
import Login from './pages/Login';
import Bookings from './pages/Bookings';
import RentProperties from './pages/RentProperties';
import SavedProperties from './pages/SavedProperties';
import Settings from './pages/Settings';
import { useAuthStore } from './store/authStore';

function App() {
  const checkAuth = useAuthStore(state => state.checkAuth);

  useEffect(() => {
    // Check auth status on app load and when tab becomes visible
    checkAuth();
    
    const handleVisibilityChange = () => {
      if (document.visibilityState === 'visible') {
        checkAuth();
      }
    };

    document.addEventListener('visibilitychange', handleVisibilityChange);
    return () => {
      document.removeEventListener('visibilitychange', handleVisibilityChange);
    };
  }, [checkAuth]);

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="house/:id" element={<HouseDetail />} />
          <Route path="login" element={<Login />} />
          <Route path="bookings" element={<Bookings />} />
          <Route path="rent" element={<RentProperties />} />
          <Route path="saved" element={<SavedProperties />} />
          <Route path="settings" element={<Settings />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;