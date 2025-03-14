import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Search, MapPin, Star, Heart, Filter, ChevronRight } from 'lucide-react';
import { mockHouses } from '../data/mockData';
import type { House } from '../types';

const BuyProperties: React.FC = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [houses, setHouses] = useState<House[]>(mockHouses);

  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    const filtered = mockHouses.filter(house => 
      house.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
      house.state.toLowerCase().includes(searchTerm.toLowerCase()) ||
      house.zipcode.includes(searchTerm)
    );
    setHouses(filtered);
  };

  return (
    <div className="pt-24 pb-16">
      <div className="max-w-8xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex flex-col md:flex-row md:items-center justify-between gap-6 mb-12">
          <div>
            <h1 className="text-4xl font-bold text-gray-900 mb-2">Properties for Sale</h1>
            <p className="text-lg text-gray-600">Find your dream home to own</p>
          </div>

          <form onSubmit={handleSearch} className="flex gap-4 w-full md:w-auto">
            <div className="flex-1 md:w-80 relative">
              <Search className="absolute left-4 top-1/2 transform -translate-y-1/2 h-5 w-5 text-gray-400" />
              <input
                type="text"
                placeholder="Search properties..."
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="w-full h-12 pl-12 pr-4 rounded-xl border border-gray-200 focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
              />
            </div>
            <button
              type="button"
              className="flex items-center gap-2 px-4 h-12 rounded-xl border-2 border-gray-200 
                hover:border-gray-300 hover:bg-gray-50 transition-all duration-200 text-gray-700"
            >
              <Filter className="h-5 w-5" />
              <span className="hidden md:inline">Filters</span>
            </button>
          </form>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 2xl:grid-cols-4 gap-8">
          {houses.map((house) => (
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
                  <Heart className="h-5 w-5 text-gray-700" />
                </button>
                <div className="absolute top-4 left-4 px-4 py-2 rounded-full text-sm font-medium 
                  bg-blue-100 text-blue-800 border border-blue-200 shadow-sm">
                  For Sale
                </div>
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
                    <span className="text-2xl font-bold text-gray-900">${house.price * 200}</span>
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

        {houses.length === 0 && (
          <div className="text-center py-12">
            <div className="w-16 h-16 mx-auto mb-4 rounded-full bg-gray-100 flex items-center justify-center">
              <Search className="h-8 w-8 text-gray-400" />
            </div>
            <h3 className="text-lg font-medium text-gray-900 mb-2">No properties found</h3>
            <p className="text-gray-600">Try adjusting your search criteria</p>
          </div>
        )}
      </div>
    </div>
  );
};

export default BuyProperties;