import { ListGuesser, ResourceProps } from "react-admin";
import { House } from "@mui/icons-material";
import ListProperties from "./list";
import CreateProperty from "./create";

export const properties: ResourceProps = {
    name: "properties",
    options: { label: "Properties" },
    icon: House,
    list: ListProperties,
    create: CreateProperty
  };