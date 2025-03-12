import { productOwners } from "./property-owners";

export function getResources(user: any) {
  if (user.role === "admin") {
    return [productOwners];
  }

  return [];
}
