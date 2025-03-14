import React from 'react';
import { Link } from 'react-router-dom';
import { MapPin, Star, Heart, ChevronRight } from 'lucide-react';
import { mockHouses } from '../data/mockData';
import { useAuthStore } from '../store/authStore';

const SavedProperties: React.FC = () => {
  const { isAuthenticated } = useAuthStore();
  const savedHouses = mockHouses.slice(0, 2); // Mock saved properties

  if (!isAuthenticated) {
    return (
      <div className="pt-24 pb-16">
        <div className="max-w-8xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="text-center py-16">
            <div className="w-16 h-16 mx-auto mb-4 rounded-full bg-gray-100 flex items-center justify-center">
              <Heart className="h-8 w-8 text-gray-400" />
            </div>
            <h2 className="text-2xl font-semibold text-gray-900 mb-4">Sign in to view saved properties</h2>
            <p className="text-gray-600 mb-8">Keep track of your favorite properties by saving them to your account</p>
            <Link
              to="/login"
              className="inline-flex items-center px-6 py-3 bg-blue-600 text-white rounded-xl
                hover:bg-blue-700 transition-colors shadow-sm hover:shadow-md"
            >
              Sign In
            </Link>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="pt-24 pb-16">
      <div className="max-w-8xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="mb-12">
          <h1 className="text-4xl font-bold text-gray-900 mb-2">Saved Properties</h1>
          <p className="text-lg text-gray-600">Your favorite properties in one place</p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 2xl:grid-cols-4 gap-8">
          {savedHouses.map((house) => (
            <Link
              key={house.id}
              to={`/house/${house.id}`}
              className="group bg-white rounded-3xl overflow-hidden shadow-sm hover:shadow-xl 
                transition-all duration-300 transform hover:-translate-y-1"
            >
              <div className="relative aspect-[4/3] overflow-hidden">
                <img
                  src={house.images[0]}
                  alt={house.title}
                  className="w-full h-full object-cover transform group-hover:scale-105 transition duration-500"
                />
                <button 
                  className="absolute top-4 right-4 p-3 rounded-full bg-white/90 backdrop-blur-sm
                    hover:bg-white transition-colors shadow-lg hover:shadow-xl"
                >
                  <Heart className="h-5 w-5 text-red-600 fill-current" />
                </button>
              </div>
              <div className="p-6">
                <div className="flex items-center justify-between mb-3">
                  <h3 className="text-xl font-semibold text-gray-900 group-hover:text-blue-600 
                    transition-colors line-clamp-1">
                    {house.title}
                  </h3>
                  <div className="flex items-center gap-1 text-gray-700 bg-gray-100 px-3 py-1 rounded-full">
                    <Star className="h-4 w-4 fill-current text-yellow-400" />
                    <span className="font-medium">4.9</span>
                  </div>
                </div>
                <div className="flex items-center text-gray-600 mb-4">
                  <MapPin className="h-5 w-5 mr-2 flex-shrink-0" />
                  <span className="truncate">{house.street}, {house.state}</span>
                </div>
                <div className="flex items-center justify-between pt-4 border-t border-gray-100">
                  <div className="flex items-baseline gap-1">
                    <span className="text-2xl font-bold text-gray-900">${house.price}</span>
                    <span className="text-gray-600">/month</span>
                  </div>
                  <div className="flex items-center gap-1 text-blue-600 font-medium group-hover:text-blue-700 
                    transition-colors">
                    View Details
                    <ChevronRight className="h-5 w-5 transform group-hover:translate-x-1 transition-transform" />
                  </div>
                </div>
              </div>
            </Link>
          ))}
        </div>

        {savedHouses.length === 0 && (
          <div className="text-center py-12">
            <div className="w-16 h-16 mx-auto mb-4 rounded-full bg-gray-100 flex items-center justify-center">
              <Heart className="h-8 w-8 text-gray-400" />
            </div>
            <h3 className="text-lg font-medium text-gray-900 mb-2">No saved properties</h3>
            <p className="text-gray-600">Start saving properties you like</p>
          </div>
        )}
      </div>
    </div>
  );
};

export default SavedProperties;