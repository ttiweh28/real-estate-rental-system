import React from 'react';
import { mockBookings } from '../data/mockData';
import { Calendar, MapPin, Clock, ChevronRight, Tag, FileText } from 'lucide-react';

const Bookings: React.FC = () => {
  return (
    <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
      <div className="flex items-center justify-between mb-8">
        <div>
          <h1 className="text-3xl font-bold text-gray-900 mb-2">My Bookings</h1>
          <p className="text-gray-600">Manage your property bookings and reservations</p>
        </div>
        <div className="flex items-center gap-4">
          <button className="px-4 py-2 text-gray-700 hover:text-gray-900 transition-colors">
            All Bookings
          </button>
          <button className="px-4 py-2 text-gray-700 hover:text-gray-900 transition-colors">
            Active
          </button>
          <button className="px-4 py-2 text-gray-700 hover:text-gray-900 transition-colors">
            Past
          </button>
        </div>
      </div>

      <div className="space-y-6">
        {mockBookings.map((booking) => (
          <div
            key={booking.id}
            className="bg-white rounded-2xl shadow-sm overflow-hidden hover:shadow-md transition-shadow duration-200"
          >
            <div className="p-6">
              <div className="flex items-start gap-6">
                <div className="relative aspect-[4/3] w-64 rounded-xl overflow-hidden flex-shrink-0">
                  <img
                    src={booking.house.images[0]}
                    alt={booking.house.title}
                    className="w-full h-full object-cover"
                  />
                  <div className="absolute inset-0 bg-gradient-to-t from-black/20 to-transparent" />
                </div>
                
                <div className="flex-1 min-w-0">
                  <div className="flex items-start justify-between gap-4 mb-4">
                    <div>
                      <h2 className="text-2xl font-semibold text-gray-900 mb-2">
                        {booking.house.title}
                      </h2>
                      <div className="flex items-center text-gray-600">
                        <MapPin className="h-5 w-5 mr-2" />
                        <span>{booking.house.street}, {booking.house.state}</span>
                      </div>
                    </div>
                    <span className={`inline-flex items-center px-4 py-2 rounded-full text-sm font-medium ${
                      booking.status === 'approved'
                        ? 'bg-green-100 text-green-800'
                        : booking.status === 'pending'
                        ? 'bg-yellow-100 text-yellow-800'
                        : 'bg-red-100 text-red-800'
                    }`}>
                      {booking.status.charAt(0).toUpperCase() + booking.status.slice(1)}
                    </span>
                  </div>

                  <div className="grid grid-cols-3 gap-6 mb-6">
                    <div className="flex items-center text-gray-600">
                      <Calendar className="h-5 w-5 mr-2" />
                      <div>
                        <p className="text-sm font-medium text-gray-900">Check-in</p>
                        <p>{new Date(booking.startDate).toLocaleDateString()}</p>
                      </div>
                    </div>
                    <div className="flex items-center text-gray-600">
                      <Calendar className="h-5 w-5 mr-2" />
                      <div>
                        <p className="text-sm font-medium text-gray-900">Check-out</p>
                        <p>{new Date(booking.endDate).toLocaleDateString()}</p>
                      </div>
                    </div>
                    <div className="flex items-center text-gray-600">
                      <Tag className="h-5 w-5 mr-2" />
                      <div>
                        <p className="text-sm font-medium text-gray-900">Price</p>
                        <p>${booking.house.price}/month</p>
                      </div>
                    </div>
                  </div>

                  <div className="flex items-center justify-between pt-4 border-t">
                    <div className="flex items-center text-gray-600">
                      <Clock className="h-5 w-5 mr-2" />
                      <span>Booked on {new Date(booking.createdAt).toLocaleDateString()}</span>
                    </div>
                    <div className="flex items-center gap-4">
                      <button className="flex items-center gap-2 text-gray-600 hover:text-gray-900 transition-colors">
                        <FileText className="h-5 w-5" />
                        <span>View Lease</span>
                      </button>
                      <button className="btn-primary flex items-center gap-2">
                        <span>View Details</span>
                        <ChevronRight className="h-5 w-5" />
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>

      {mockBookings.length === 0 && (
        <div className="text-center py-12">
          <div className="w-16 h-16 mx-auto mb-4 rounded-full bg-gray-100 flex items-center justify-center">
            <Calendar className="h-8 w-8 text-gray-400" />
          </div>
          <h3 className="text-lg font-medium text-gray-900 mb-2">No bookings yet</h3>
          <p className="text-gray-600">Start exploring properties to make your first booking</p>
        </div>
      )}
    </div>
  );
};

export default Bookings;