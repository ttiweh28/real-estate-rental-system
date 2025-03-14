import React, { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { 
  Check, X, MapPin, DollarSign, Calendar, Clock, User,
  Heart, Share, Star, Home as HomeIcon, Shield, Coffee,
  Wifi, Car, Bath, BedDouble, ArrowLeft, ArrowRight
} from 'lucide-react';
import { mockHouses } from '../data/mockData';
import { useAuthStore } from '../store/authStore';

const HouseDetail: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const { isAuthenticated } = useAuthStore();
  const [showBookingForm, setShowBookingForm] = useState(false);
  const [selectedImage, setSelectedImage] = useState(0);

  const house = mockHouses.find(h => h.id === id);

  if (!house) {
    return (
      <div className="min-h-[60vh] flex items-center justify-center">
        <div className="text-center">
          <div className="mb-6">
            <HomeIcon className="h-16 w-16 text-gray-400 mx-auto" />
          </div>
          <h2 className="text-2xl font-bold text-gray-900 mb-2">Property not found</h2>
          <p className="text-gray-600 mb-8">The property you're looking for doesn't exist or has been removed.</p>
          <button
            onClick={() => navigate('/')}
            className="btn-primary"
          >
            Return Home
          </button>
        </div>
      </div>
    );
  }

  const handleBook = () => {
    if (!isAuthenticated) {
      navigate('/login');
      return;
    }
    setShowBookingForm(true);
  };

  const nextImage = () => {
    setSelectedImage((prev) => (prev + 1) % house.images.length);
  };

  const prevImage = () => {
    setSelectedImage((prev) => (prev - 1 + house.images.length) % house.images.length);
  };

  return (
    <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
      {/* Property Header */}
      <div className="mb-8">
        <div className="flex items-center gap-4 text-sm text-gray-600 mb-4">
          <button onClick={() => navigate(-1)} className="flex items-center gap-1 hover:text-blue-600 transition-colors">
            <ArrowLeft className="h-4 w-4" />
            Back to search
          </button>
          <span>•</span>
          <span>Property #{house.id}</span>
        </div>
        <div className="flex items-start justify-between gap-8">
          <div>
            <h1 className="text-4xl font-bold text-gray-900 mb-4">{house.title}</h1>
            <div className="flex items-center gap-6 text-gray-600">
              <div className="flex items-center gap-2">
                <MapPin className="h-5 w-5" />
                <span>{house.street}, {house.state}, {house.zipcode}</span>
              </div>
              <div className="flex items-center gap-2">
                <Star className="h-5 w-5 fill-current text-yellow-400" />
                <span className="font-medium">4.9</span>
                <span className="text-gray-400">(128 reviews)</span>
              </div>
            </div>
          </div>
          <div className="flex items-center gap-4">
            <button className="p-3 rounded-full hover:bg-gray-100 transition-colors">
              <Share className="h-6 w-6 text-gray-600" />
            </button>
            <button className="p-3 rounded-full hover:bg-gray-100 transition-colors">
              <Heart className="h-6 w-6 text-gray-600" />
            </button>
          </div>
        </div>
      </div>

      {/* Image Gallery */}
      <div className="relative rounded-3xl overflow-hidden mb-12">
        <div className="aspect-[16/9]">
          <img
            src={house.images[selectedImage]}
            alt={`${house.title} - Image ${selectedImage + 1}`}
            className="w-full h-full object-cover"
          />
        </div>
        <button
          onClick={prevImage}
          className="absolute left-4 top-1/2 -translate-y-1/2 p-2 rounded-full bg-white/90 hover:bg-white shadow-lg transition-colors"
        >
          <ArrowLeft className="h-6 w-6" />
        </button>
        <button
          onClick={nextImage}
          className="absolute right-4 top-1/2 -translate-y-1/2 p-2 rounded-full bg-white/90 hover:bg-white shadow-lg transition-colors"
        >
          <ArrowRight className="h-6 w-6" />
        </button>
        <div className="absolute bottom-4 left-1/2 -translate-x-1/2 flex items-center gap-2 px-4 py-2 rounded-full bg-white/90 backdrop-blur-sm">
          {house.images.map((_, index) => (
            <button
              key={index}
              onClick={() => setSelectedImage(index)}
              className={`w-2 h-2 rounded-full transition-colors ${
                selectedImage === index ? 'bg-blue-600' : 'bg-gray-300'
              }`}
            />
          ))}
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-12">
        {/* Main Content */}
        <div className="lg:col-span-2">
          {/* Property Details */}
          <div className="bg-white rounded-2xl p-8 shadow-sm mb-8">
            <div className="flex items-center justify-between pb-6 mb-6 border-b">
              <div>
                <h2 className="text-2xl font-semibold text-gray-900 mb-2">Property Details</h2>
                <p className="text-gray-600">Everything you need to know</p>
              </div>
              <Shield className="h-8 w-8 text-blue-600" />
            </div>
            <div className="grid grid-cols-2 md:grid-cols-4 gap-6">
              <div className="flex items-center gap-3">
                <BedDouble className="h-6 w-6 text-gray-600" />
                <div>
                  <p className="font-medium text-gray-900">4 Beds</p>
                  <p className="text-sm text-gray-600">Comfortable</p>
                </div>
              </div>
              <div className="flex items-center gap-3">
                <Bath className="h-6 w-6 text-gray-600" />
                <div>
                  <p className="font-medium text-gray-900">2 Baths</p>
                  <p className="text-sm text-gray-600">Spacious</p>
                </div>
              </div>
              <div className="flex items-center gap-3">
                <Car className="h-6 w-6 text-gray-600" />
                <div>
                  <p className="font-medium text-gray-900">2 Parking</p>
                  <p className="text-sm text-gray-600">Covered</p>
                </div>
              </div>
              <div className="flex items-center gap-3">
                <Coffee className="h-6 w-6 text-gray-600" />
                <div>
                  <p className="font-medium text-gray-900">Kitchen</p>
                  <p className="text-sm text-gray-600">Fully equipped</p>
                </div>
              </div>
            </div>
          </div>

          {/* Description */}
          <div className="bg-white rounded-2xl p-8 shadow-sm mb-8">
            <h2 className="text-2xl font-semibold text-gray-900 mb-6">About this property</h2>
            <p className="text-gray-600 leading-relaxed mb-6">{house.description}</p>
            <div className="grid grid-cols-2 gap-6">
              {house.amenities.map((amenity, index) => (
                <div key={index} className="flex items-center gap-3">
                  <div className="flex-shrink-0 w-8 h-8 rounded-full bg-blue-100 flex items-center justify-center">
                    <Check className="h-5 w-5 text-blue-600" />
                  </div>
                  <span className="text-gray-700">{amenity}</span>
                </div>
              ))}
            </div>
          </div>

          {/* Location */}
          <div className="bg-white rounded-2xl p-8 shadow-sm">
            <h2 className="text-2xl font-semibold text-gray-900 mb-6">Location</h2>
            <div className="aspect-[16/9] rounded-xl overflow-hidden bg-gray-100 mb-6">
              {/* Map placeholder - In a real app, integrate with Google Maps or similar */}
              <div className="w-full h-full flex items-center justify-center text-gray-400">
                Map View
              </div>
            </div>
            <div className="flex items-center gap-3 text-gray-600">
              <MapPin className="h-5 w-5 flex-shrink-0" />
              <p>{house.street}, {house.state}, {house.zipcode}</p>
            </div>
          </div>
        </div>

        {/* Booking Card */}
        <div className="lg:col-span-1">
          <div className="sticky top-24">
            <div className="bg-white rounded-2xl p-6 shadow-sm">
              <div className="flex items-baseline gap-2 mb-6">
                <span className="text-3xl font-bold text-gray-900">${house.price}</span>
                <span className="text-gray-600">/month</span>
              </div>
              
              {house.availability ? (
                <button
                  onClick={handleBook}
                  className="w-full btn-primary mb-6"
                >
                  Book Now
                </button>
              ) : (
                <button
                  disabled
                  className="w-full btn-primary opacity-50 cursor-not-allowed mb-6"
                >
                  Not Available
                </button>
              )}

              <div className="space-y-4 text-sm">
                <div className="flex items-center gap-2 text-gray-600">
                  <Shield className="h-5 w-5 text-green-600" />
                  <span>Verified property</span>
                </div>
                <div className="flex items-center gap-2 text-gray-600">
                  <Clock className="h-5 w-5" />
                  <span>Usually responds within 24 hours</span>
                </div>
                <div className="flex items-center gap-2 text-gray-600">
                  <Wifi className="h-5 w-5" />
                  <span>High-speed internet included</span>
                </div>
              </div>
            </div>

            {/* Property Owner */}
            <div className="bg-white rounded-2xl p-6 shadow-sm mt-6">
              <h3 className="font-semibold text-gray-900 mb-4">Property Owner</h3>
              <div className="flex items-center gap-4">
                <div className="w-12 h-12 rounded-full bg-gray-100 flex items-center justify-center">
                  <User className="h-6 w-6 text-gray-600" />
                </div>
                <div>
                  <p className="font-medium text-gray-900">
                    {house.owner.firstName} {house.owner.lastName}
                  </p>
                  <p className="text-sm text-gray-600">Property Owner</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      {/* Booking Modal */}
      {showBookingForm && (
        <div className="fixed inset-0 bg-black/50 backdrop-blur-sm flex items-center justify-center p-4 z-50">
          <div className="bg-white rounded-2xl p-8 max-w-lg w-full animate-slide-up">
            <div className="flex justify-between items-center mb-6">
              <h2 className="text-2xl font-semibold text-gray-900">Book Your Stay</h2>
              <button
                onClick={() => setShowBookingForm(false)}
                className="p-2 hover:bg-gray-100 rounded-full transition-colors"
              >
                <X className="h-6 w-6 text-gray-500" />
              </button>
            </div>
            
            <form className="space-y-6">
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-2">
                  Move-in Date
                </label>
                <div className="relative">
                  <Calendar className="absolute left-4 top-1/2 transform -translate-y-1/2 h-5 w-5 text-gray-400" />
                  <input
                    type="date"
                    className="input-field pl-12"
                  />
                </div>
              </div>
              
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-2">
                  Duration (months)
                </label>
                <div className="relative">
                  <Clock className="absolute left-4 top-1/2 transform -translate-y-1/2 h-5 w-5 text-gray-400" />
                  <input
                    type="number"
                    min="1"
                    className="input-field pl-12"
                    placeholder="Enter duration in months"
                  />
                </div>
              </div>
              
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-2">
                  Additional Notes
                </label>
                <textarea
                  className="input-field"
                  rows={4}
                  placeholder="Any special requirements or questions?"
                />
              </div>

              <div className="pt-4">
                <button type="submit" className="btn-primary w-full">
                  Confirm Booking
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};

export default HouseDetail;