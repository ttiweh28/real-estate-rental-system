import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { 
  Search, MapPin, DollarSign, Home as HomeIcon, Star, Heart, Filter,
  Calendar, Headphones as HeadphonesIcon, ChevronRight
} from 'lucide-react';
import { mockHouses } from '../data/mockData';
import type { House } from '../types';

const Home: React.FC = () => {
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
    <div className="min-h-screen pt-20">
      {/* Hero Section */}
      <div className="relative h-[95vh] w-full">
        <div className="absolute inset-0">
          <img
            src="https://images.unsplash.com/photo-1613977257363-707ba9348227?auto=format&fit=crop&q=80"
            alt="Luxury Home"
            className="w-full h-full object-cover"
          />
          <div className="absolute inset-0 bg-gradient-to-r from-black/90 via-black/70 to-transparent" />
        </div>
        <div className="relative h-full max-w-8xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="h-full flex flex-col justify-center max-w-3xl">
            <h1 className="text-7xl md:text-8xl font-bold text-white mb-8 leading-tight animate-fade-in">
              Discover <br />
              <span className="text-blue-400">Extraordinary</span> <br />
              Living
            </h1>
            <p className="text-2xl text-gray-200 mb-12 max-w-2xl animate-slide-up leading-relaxed">
              Experience unparalleled elegance in our curated collection of the world's most prestigious rental properties.
            </p>
            <form onSubmit={handleSearch} className="flex flex-col md:flex-row gap-4 animate-slide-up">
              <div className="flex-1 relative">
                <Search className="absolute left-6 top-1/2 transform -translate-y-1/2 h-6 w-6 text-gray-400" />
                <input
                  type="text"
                  placeholder="Search by location, zip code, or property name..."
                  value={searchTerm}
                  onChange={(e) => setSearchTerm(e.target.value)}
                  className="w-full h-16 pl-16 pr-6 rounded-2xl bg-white/95 backdrop-blur-sm 
                    border-0 text-gray-900 text-lg placeholder:text-gray-400
                    focus:ring-4 focus:ring-blue-500/20 shadow-xl"
                />
              </div>
              <button
                type="submit"
                className="h-16 px-8 rounded-2xl bg-blue-600 hover:bg-blue-700 text-white 
                  font-medium transition-all duration-200 shadow-xl hover:shadow-2xl
                  transform hover:-translate-y-0.5 text-lg flex items-center justify-center gap-2"
              >
                <Search className="h-6 w-6" />
                Search
              </button>
            </form>
          </div>
        </div>
      </div>

      {/* Featured Properties */}
      <div className="max-w-8xl mx-auto px-4 sm:px-6 lg:px-8 py-24">
        <div className="flex items-center justify-between mb-12">
          <div>
            <h2 className="text-4xl font-bold text-gray-900 mb-4">Featured Properties</h2>
            <p className="text-xl text-gray-600">Exceptional homes for discerning tastes</p>
          </div>
          <button className="flex items-center gap-3 px-6 py-3 rounded-xl border-2 border-gray-200 
            hover:border-gray-300 hover:bg-gray-50 transition-all duration-200 text-gray-700 font-medium">
            <Filter className="h-5 w-5" />
            Filters
          </button>
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
                {house.availability && (
                  <div className="absolute top-4 left-4 px-4 py-2 rounded-full text-sm font-medium 
                    bg-white/90 backdrop-blur-sm text-blue-800 border border-white/20 shadow-sm">
                    Available Now
                  </div>
                )}
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
                  <button className="flex items-center gap-1 text-blue-600 font-medium hover:text-blue-700 
                    transition-colors group">
                    View Details
                    <ChevronRight className="h-5 w-5 transform group-hover:translate-x-1 transition-transform" />
                  </button>
                </div>
              </div>
            </Link>
          ))}
        </div>

        <div className="mt-16 text-center">
          <Link
            to="/rent"
            className="inline-flex items-center gap-2 px-8 py-4 bg-gray-900 hover:bg-gray-800 
              text-white rounded-2xl transition-all duration-200 transform hover:-translate-y-0.5
              shadow-xl hover:shadow-2xl font-medium text-lg"
          >
            Explore More Properties
            <ChevronRight className="h-5 w-5" />
          </Link>
        </div>
      </div>

      {/* Features Section */}
      <div className="bg-gradient-to-br from-gray-900 to-gray-800 py-32">
        <div className="max-w-8xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="text-center mb-20">
            <h2 className="text-4xl font-bold text-white mb-6">The Luxury Experience</h2>
            <p className="text-xl text-gray-300 max-w-3xl mx-auto">
              Indulge in the perfect blend of sophistication and comfort with our premium property services
            </p>
          </div>
          <div className="grid grid-cols-1 md:grid-cols-3 gap-12">
            {[
              {
                title: 'Curated Properties',
                description: 'Each residence is hand-selected to meet our exceptional standards of luxury and quality',
                icon: <HomeIcon className="h-8 w-8 text-blue-400" />
              },
              {
                title: 'VIP Booking',
                description: 'Experience seamless reservations with our dedicated concierge service',
                icon: <Calendar className="h-8 w-8 text-blue-400" />
              },
              {
                title: 'Premium Support',
                description: 'Our elite support team is available 24/7 to cater to your every need',
                icon: <HeadphonesIcon className="h-8 w-8 text-blue-400" />
              }
            ].map((feature, index) => (
              <div key={index} className="bg-white/10 backdrop-blur-lg rounded-3xl p-8 text-center transform 
                hover:-translate-y-1 transition-all duration-300 hover:shadow-2xl border border-white/10">
                <div className="inline-flex items-center justify-center w-20 h-20 rounded-2xl 
                  bg-blue-600/20 mb-8">
                  {feature.icon}
                </div>
                <h3 className="text-2xl font-semibold text-white mb-4">{feature.title}</h3>
                <p className="text-gray-300 text-lg leading-relaxed">{feature.description}</p>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;