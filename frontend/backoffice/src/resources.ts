import { bookings } from "./booking";
import { properties } from "./property";
import { productOwners } from "./property-owners";

export function getResources(role: string) {
  if (role === "admin") {
    return [productOwners];
  }

  return [properties, bookings];
}
