"use client";

import fakeDataProvider from "ra-data-fakerest";
import { getResources } from "./resources";
import { Admin, Resource } from "react-admin";
import authProvider from "./state/providers/authProvider";

const dataProvider = fakeDataProvider({
  PropertyOwners: [
    { id: 1, firstName: "Justine", lastName: "Okumu", username: "okumujustine" },
    { id: 2, firstName: "Sunday", lastName: "Nyeko", username: "sundayn" },
  ],
});

export default function AdminApp() {
  const user = {
    role: "admin",
  };

  return (
    <Admin dataProvider={dataProvider} authProvider={authProvider}>
      {() =>
        getResources(user).map((resource) => {
          return <Resource key={resource.name} {...resource} />;
        })
      }
    </Admin>
  );
}
