import React from 'react';
import { Outlet } from 'react-router-dom';
import Navbar from './Navbar';

const Layout: React.FC = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-gray-50 to-gray-100">
      <Navbar />
      <main className="container mx-auto px-4 py-8 animate-fade-in">
        <Outlet />
      </main>
      <footer className="bg-white/80 backdrop-blur-sm border-t border-gray-100 py-8 mt-16">
        <div className="container mx-auto px-4">
          <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
            <div>
              <h3 className="text-lg font-semibold mb-4">About Us</h3>
              <p className="text-gray-600">
                We're dedicated to helping you find your perfect home with our extensive collection of premium properties.
              </p>
            </div>
            <div>
              <h3 className="text-lg font-semibold mb-4">Quick Links</h3>
              <ul className="space-y-2">
                <li><a href="#" className="text-gray-600 hover:text-blue-600 transition-colors">Properties</a></li>
                <li><a href="#" className="text-gray-600 hover:text-blue-600 transition-colors">Contact Us</a></li>
                <li><a href="#" className="text-gray-600 hover:text-blue-600 transition-colors">Terms of Service</a></li>
                <li><a href="#" className="text-gray-600 hover:text-blue-600 transition-colors">Privacy Policy</a></li>
              </ul>
            </div>
            <div>
              <h3 className="text-lg font-semibold mb-4">Contact</h3>
              <ul className="space-y-2 text-gray-600">
                <li>Email: contact@realestate.com</li>
                <li>Phone: (555) 123-4567</li>
                <li>Address: 123 Main St, City, State</li>
              </ul>
            </div>
          </div>
          <div className="mt-8 pt-8 border-t border-gray-100 text-center text-gray-600">
            <p>&copy; 2024 RealEstate. All rights reserved.</p>
          </div>
        </div>
      </footer>
    </div>
  );
};

export default Layout;