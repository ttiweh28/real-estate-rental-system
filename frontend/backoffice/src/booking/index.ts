import { ListGuesser, ResourceProps, ShowGuesser } from "react-admin";
import { Bookmark } from "@mui/icons-material";

export const bookings: ResourceProps = {
    name: "bookings",
    options: { label: "Booking" },
    icon: Bookmark,
    list: ListGuesser,
  };