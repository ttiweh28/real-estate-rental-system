import { bookings } from "./bookings";
import { properties } from "./properties";
import { productOwners } from "./property-owners";
import { E_UserRole } from "./types/authTypes";

export function getResources(role: E_UserRole) {
  if (role === "ROLE_ADMIN") {
    return [productOwners];
  }

  return [properties, bookings];
}
