"use client";

import { deepmerge } from '@mui/utils';
import { getResources } from "./resources";
import { Admin, combineDataProviders, fetchUtils, radiantDarkTheme, Resource } from "react-admin";
import authProvider from "./state/providers/authProvider";
import { ReactQueryDevtools } from "@tanstack/react-query-devtools";
import { bookingDataProvider } from "./providers/bookingDataProvider";
import { propertyOwnersDataProvider } from "./providers/propertyOwnersDataProvider";


const dataProvider = combineDataProviders((resource: string) => {
  switch (resource) {
    case "bookings":
      return { ...bookingDataProvider };
    case "property-owners":
      return { ...propertyOwnersDataProvider };
    default:
      throw new Error(`Unknown resource: ${resource}`);
  }
});

export default function AdminApp() {
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
      <ReactQueryDevtools initialIsOpen={false} />
    </Admin>
  );
}
