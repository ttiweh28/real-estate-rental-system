"use client";

import fakeDataProvider from "ra-data-fakerest";
import { getResources } from "./resources";
import { Admin, Resource } from "react-admin";
import authProvider from "./state/providers/authProvider";
import { I_User } from "./types/authTypes";

const dataProvider = fakeDataProvider({
  PropertyOwners: [
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
      firstName: "Justine",
      lastName: "Okumu",
      username: "okumujustine",
    },
    { id: 2, firstName: "Sunday", lastName: "Nyeko", username: "sundayn" },
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

  return (
    <Admin dataProvider={dataProvider} authProvider={authProvider}>
      {(currentUserRole) => {
        return getResources(currentUserRole).map((resource) => {
          return <Resource key={resource.name} {...resource} />;
        });
      }}
    </Admin>
  );
}
