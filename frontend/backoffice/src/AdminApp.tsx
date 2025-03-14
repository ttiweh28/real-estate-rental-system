"use client";

import fakeDataProvider from "ra-data-fakerest";
import { deepmerge } from '@mui/utils';
import { getResources } from "./resources";
import { Admin, radiantDarkTheme, Resource } from "react-admin";
import authProvider from "./state/providers/authProvider";
import { I_User } from "./types/authTypes";

const dataProvider = fakeDataProvider({
  propertyOwners: [
    {
      id: 1,
      firstName: "Justine",
      lastName: "Okumu",
      username: "okumujustine",
    },
    { id: 2, firstName: "Sunday", lastName: "Nyeko", username: "sundayn" },
  ],

  properties: [
    {
      id: 1,
      name: "Luxurous house",
      banner: 'https://images.unsplash.com/photo-1613490493576-7fde63acd811?auto=format&fit=crop&q=80&w=1600',
      location: "Fairfied",
      price: "45000",
      images: [
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f"
      ],
      propertyOwner: {
        id: 1,
        firstName: "Okello",
        lastName: "John",
        username: "johny",
      },
      isBooked: true,
      amenities: ['Pool', 'Beach Access', 'Smart Home'],
       description: "Description here"
    },
    {
      id: 2,
      name: "Luxurous house 2",
      banner: 'https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?auto=format&fit=crop&q=80&w=1600',
      images: [
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f"
      ],
      location: "Fairfied",
      price: "45000",
      propertyOwner: {
        id: 2,
        firstName: "Sunday",
        lastName: "Nyeko",
        username: "sundayson",
      },
      isBooked: false,
      amenities: ['Pool', 'Beach Access', 'Smart Home'],
       description: "Description here"
    },
    {
      id: 3,
      name: "Seaside Villa",
      banner: 'https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?auto=format&fit=crop&q=80&w=1600',
      images: [
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f"
      ],
      location: "Seaside",
      price: "65000",
      propertyOwner: {
        id: 3,
        firstName: "Grace",
        lastName: "Ocen",
        username: "graceocen",
      },
      isBooked: false,
      amenities: ['Infinity Pool', 'Private Beach', 'Spa'],
      description: "Description here"
    },
    {
      id: 4,
      name: "Mountain Retreat",
      banner: 'https://images.unsplash.com/photo-1512917774080-9991f1c4c750?auto=format&fit=crop&q=80&w=1600',
      images: [
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
        "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f"
      ],
      location: "Mountain Range",
      price: "55000",
      propertyOwner: {
        id: 4,
        firstName: "Peter",
        lastName: "Otto",
        username: "peterotto",
      },
      isBooked: false,
      amenities: ['Panoramic Views', 'Hiking Trails', 'Fireplace'],
       description: "Description here"
    }
    
  ],

  bookings: [
    {
      id: 1,
      firstName: "Justine",
      lastName: "Okumu",
      username: "okumujustine",
    },
    { id: 2, firstName: "Sunday", lastName: "Nyeko", username: "sundayn" },
  ],
});

export default function AdminApp() {
  const user: I_User = {
    id: "user456",
    firstName: "Tiffany",
    lastName: "Lamaro",
    username: "tiffany",
    fullName: "Lamaro Tiffany",
    role: "admin",
    password: "1234",
    avatar: "https://example.com/avatar.jpg",
  };

  const theme = deepmerge(radiantDarkTheme, {
    sidebar: {
        width: 220, // The default value is 240
        closedWidth: 70, // The default value is 55
    },
});

  return (
    <Admin
      darkTheme={theme}
      dataProvider={dataProvider}
      authProvider={authProvider}
    >
      {(currentUserRole) => {
        return getResources(currentUserRole).map((resource) => {
          return <Resource key={resource.name} {...resource} />;
        });
      }}
    </Admin>
  );
}
