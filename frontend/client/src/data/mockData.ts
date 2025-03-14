import { House, User, Booking, PropertyOwner } from '../types';

export const mockUser: User = {
  firstName: 'John',
  lastName: 'Doe',
  username: 'johndoe',
  role: 'tenant'
};

export const mockOwner: PropertyOwner = {
  firstName: 'Jane',
  lastName: 'Smith',
  username: 'janesmith',
  role: 'owner'
};

export const mockHouses: House[] = [
  {
    id: '1',
    title: 'Elegant Penthouse with City Views',
    description: 'Luxurious penthouse featuring panoramic city views, private terrace, and premium finishes throughout',
    amenities: ['Private Elevator', 'Wine Cellar', 'Smart Home System', 'Concierge Service'],
    availability: true,
    price: 12500,
    zipcode: '90210',
    street: '1200 Beverly Hills Dr',
    state: 'CA',
    images: [
      'https://images.unsplash.com/photo-1600607687939-ce8a6c25118c?auto=format&fit=crop&q=80',
      'https://images.unsplash.com/photo-1600607687644-c7171b42498f?auto=format&fit=crop&q=80'
    ],
    owner: mockOwner
  },
  {
    id: '2',
    title: 'Mediterranean Villa Estate',
    description: 'Stunning villa with infinity pool, private gardens, and luxury amenities',
    amenities: ['Infinity Pool', 'Tennis Court', 'Home Theater', 'Guest House'],
    availability: true,
    price: 18500,
    zipcode: '90211',
    street: '800 Sunset Boulevard',
    state: 'CA',
    images: [
      'https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?auto=format&fit=crop&q=80',
      'https://images.unsplash.com/photo-1600585154340-be6161a56a0c?auto=format&fit=crop&q=80'
    ],
    owner: mockOwner
  }
];

export const mockBookings: Booking[] = [
  {
    id: '1',
    houseId: '1',
    house: mockHouses[0],
    tenant: mockUser,
    startDate: '2024-03-01',
    endDate: '2024-03-31',
    status: 'approved',
    createdAt: '2024-02-15'
  }
];