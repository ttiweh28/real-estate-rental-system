import { ListGuesser, ResourceProps, ShowGuesser } from "react-admin";
import { Person2 } from "@mui/icons-material";
import { CreatePropertyOwner } from "./create";
import { EditPropertyOwner } from "./edit";
import { ListPropertyOwners } from "./list";

export const productOwners: ResourceProps = {
    name: "PropertyOwners",
    options: { label: "Property Owners" },
    icon: Person2,
    list: ListPropertyOwners,
    edit: EditPropertyOwner,
    create: CreatePropertyOwner,
    show: ShowGuesser,
  };