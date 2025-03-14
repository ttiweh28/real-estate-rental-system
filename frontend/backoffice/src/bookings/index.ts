import { ListGuesser, ResourceProps } from "react-admin";
import { Bookmark } from "@mui/icons-material";

export const bookings: ResourceProps = {
    name: "bookings",
    options: { label: "Bookings" },
    icon: Bookmark,
    list: ListGuesser,
  };