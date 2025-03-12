import { bookings } from "./bookings";
import { properties } from "./properties";
import { productOwners } from "./property-owners";

export function getResources(role: string) {
  if (role === "admin") {
    return [productOwners];
  }

  return [properties, bookings];
}
