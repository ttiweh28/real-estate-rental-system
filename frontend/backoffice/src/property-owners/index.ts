import { EditGuesser, ListGuesser, ResourceProps, ShowGuesser, } from "react-admin";
import { Person2 } from "@mui/icons-material";
import { CreatePropertyOwner } from "./create";
import { EditPropertyOwner } from "./edit";
import { ListPropertyOwners } from "./list";
import { ShowPropertyOwner } from "./show";

export const productOwners: ResourceProps = {
    name: "property-owners",
    options: { label: "Property Owners" },
    icon: Person2,
    // list: ListGuesser,
    show: ShowGuesser,
    edit: EditGuesser,
    list: ListPropertyOwners,
    // edit: EditPropertyOwner,
    create: CreatePropertyOwner,
    // show: ShowPropertyOwner,
  };