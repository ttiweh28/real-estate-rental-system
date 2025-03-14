import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useLocation } from 'react-router-dom';
import { 
  Home, LogOut, User, Menu, X, Search, Heart, Bell, 
  ChevronDown, Building, Calendar, Settings
} from 'lucide-react';
import { useAuthStore } from '../store/authStore';

const Navbar: React.FC = () => {
  const { isAuthenticated, logout } = useAuthStore();
  const navigate = useNavigate();
  const location = useLocation();
  const [isScrolled, setIsScrolled] = useState(false);
  const [isMobileMenuOpen, setIsMobileMenuOpen] = useState(false);
  const [isProfileMenuOpen, setIsProfileMenuOpen] = useState(false);

  useEffect(() => {
    const handleScroll = () => {
      setIsScrolled(window.scrollY > 20);
    };

    window.addEventListener('scroll', handleScroll);
    return () => window.removeEventListener('scroll', handleScroll);
  }, []);

  const handleLogout = () => {
    logout();
    navigate('/login');
    setIsMobileMenuOpen(false);
    setIsProfileMenuOpen(false);
  };

  const navLinks = [
    { name: 'Rent', href: '/rent', icon: Building },
    { name: 'Saved', href: '/saved', icon: Heart },
  ];

  return (
    <>
      <nav 
        className={`fixed top-0 left-0 right-0 z-50 transition-all duration-300 ${
          isScrolled 
            ? 'bg-white/80 backdrop-blur-lg shadow-sm' 
            : 'bg-transparent'
        }`}
      >
        <div className="max-w-8xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="flex items-center justify-between h-20">
            {/* Logo */}
            <Link 
              to="/" 
              className="flex items-center space-x-3 text-blue-600 transition-transform hover:scale-105"
            >
              <Home className="h-8 w-8" />
              <span className="font-bold text-2xl tracking-tight">LuxuryEstate</span>
            </Link>

            {/* Desktop Navigation */}
            <div className="hidden md:flex items-center space-x-1">
              {navLinks.map((link) => {
                const Icon = link.icon;
                return (
                  <Link
                    key={link.name}
                    to={link.href}
                    className={`px-4 py-2 rounded-xl flex items-center space-x-2 transition-all duration-200
                      ${location.pathname === link.href
                        ? 'text-blue-600 bg-blue-50'
                        : 'text-gray-700 hover:bg-gray-50'
                      }`}
                  >
                    <Icon className="h-5 w-5" />
                    <span>{link.name}</span>
                  </Link>
                );
              })}
            </div>

            {/* Desktop Right Section */}
            <div className="hidden md:flex items-center space-x-4">
              {isAuthenticated ? (
                <>
                  <button className="p-2 rounded-xl hover:bg-gray-100 transition-colors relative">
                    <Bell className="h-5 w-5 text-gray-700" />
                    <span className="absolute top-1 right-1 w-2 h-2 bg-blue-600 rounded-full" />
                  </button>
                  
                  <div className="relative">
                    <button
                      onClick={() => setIsProfileMenuOpen(!isProfileMenuOpen)}
                      className="flex items-center space-x-3 px-4 py-2 rounded-xl hover:bg-gray-100 
                        transition-colors focus:outline-none"
                    >
                      <div className="w-8 h-8 rounded-full bg-blue-100 flex items-center justify-center">
                        <User className="h-5 w-5 text-blue-600" />
                      </div>
                      <ChevronDown className={`h-5 w-5 text-gray-600 transition-transform duration-200
                        ${isProfileMenuOpen ? 'rotate-180' : ''}`} 
                      />
                    </button>

                    {isProfileMenuOpen && (
                      <div className="absolute right-0 mt-2 w-48 bg-white rounded-xl shadow-lg py-2
                        border border-gray-100 animate-fade-in">
                        <Link
                          to="/bookings"
                          className="flex items-center space-x-3 px-4 py-3 text-gray-700 hover:bg-gray-50
                            transition-colors"
                        >
                          <Calendar className="h-5 w-5" />
                          <span>My Bookings</span>
                        </Link>
                        <Link
                          to="/settings"
                          className="flex items-center space-x-3 px-4 py-3 text-gray-700 hover:bg-gray-50
                            transition-colors"
                        >
                          <Settings className="h-5 w-5" />
                          <span>Settings</span>
                        </Link>
                        <button
                          onClick={handleLogout}
                          className="flex items-center space-x-3 px-4 py-3 text-red-600 hover:bg-red-50
                            transition-colors w-full"
                        >
                          <LogOut className="h-5 w-5" />
                          <span>Logout</span>
                        </button>
                      </div>
                    )}
                  </div>
                </>
              ) : (
                <Link
                  to="/login"
                  className="flex items-center space-x-2 px-6 py-2.5 bg-blue-600 text-white rounded-xl
                    hover:bg-blue-700 transition-colors shadow-sm hover:shadow-md"
                >
                  <User className="h-5 w-5" />
                  <span className="font-medium">Sign In</span>
                </Link>
              )}
            </div>

            {/* Mobile Menu Button */}
            <button
              onClick={() => setIsMobileMenuOpen(!isMobileMenuOpen)}
              className="md:hidden p-2 rounded-xl hover:bg-gray-100 transition-colors"
            >
              {isMobileMenuOpen ? (
                <X className="h-6 w-6 text-gray-900" />
              ) : (
                <Menu className="h-6 w-6 text-gray-900" />
              )}
            </button>
          </div>
        </div>

        {/* Mobile Navigation */}
        {isMobileMenuOpen && (
          <div className="md:hidden bg-white border-t border-gray-100 animate-fade-in">
            <div className="max-w-8xl mx-auto px-4 py-4 space-y-2">
              {navLinks.map((link) => {
                const Icon = link.icon;
                return (
                  <Link
                    key={link.name}
                    to={link.href}
                    onClick={() => setIsMobileMenuOpen(false)}
                    className={`flex items-center space-x-3 px-4 py-3 rounded-xl transition-colors
                      ${location.pathname === link.href
                        ? 'text-blue-600 bg-blue-50'
                        : 'text-gray-700 hover:bg-gray-50'
                      }`}
                  >
                    <Icon className="h-5 w-5" />
                    <span>{link.name}</span>
                  </Link>
                );
              })}

              {isAuthenticated ? (
                <>
                  <Link
                    to="/bookings"
                    onClick={() => setIsMobileMenuOpen(false)}
                    className="flex items-center space-x-3 px-4 py-3 text-gray-700 hover:bg-gray-50
                      rounded-xl transition-colors"
                  >
                    <Calendar className="h-5 w-5" />
                    <span>My Bookings</span>
                  </Link>
                  <Link
                    to="/settings"
                    onClick={() => setIsMobileMenuOpen(false)}
                    className="flex items-center space-x-3 px-4 py-3 text-gray-700 hover:bg-gray-50
                      rounded-xl transition-colors"
                  >
                    <Settings className="h-5 w-5" />
                    <span>Settings</span>
                  </Link>
                  <button
                    onClick={handleLogout}
                    className="flex items-center space-x-3 px-4 py-3 text-red-600 hover:bg-red-50
                      rounded-xl transition-colors w-full"
                  >
                    <LogOut className="h-5 w-5" />
                    <span>Logout</span>
                  </button>
                </>
              ) : (
                <Link
                  to="/login"
                  onClick={() => setIsMobileMenuOpen(false)}
                  className="flex items-center space-x-2 px-6 py-3 bg-blue-600 text-white rounded-xl
                    hover:bg-blue-700 transition-colors w-full justify-center"
                >
                  <User className="h-5 w-5" />
                  <span className="font-medium">Sign In</span>
                </Link>
              )}
            </div>
          </div>
        )}
      </nav>

      {/* Backdrop for mobile menu */}
      {isMobileMenuOpen && (
        <div 
          className="fixed inset-0 bg-black/20 backdrop-blur-sm z-40 md:hidden"
          onClick={() => setIsMobileMenuOpen(false)}
        />
      )}

      {/* Backdrop for profile menu */}
      {isProfileMenuOpen && (
        <div 
          className="fixed inset-0 z-40 hidden md:block"
          onClick={() => setIsProfileMenuOpen(false)}
        />
      )}
    </>
  );
};

export default Navbar;