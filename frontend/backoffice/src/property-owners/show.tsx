import { PropertyOwnerAvatar } from "@/components/property-owners/OwnerAvatar";
import { Show, ShowProps, SimpleShowLayout, TextField } from "react-admin";

export const ShowPropertyOwner = (props: ShowProps) => (
  <Show {...props} >
    <SimpleShowLayout>
      <PropertyOwnerAvatar size="large" />
      <TextField sx={{ fontSize: "18px"}} source="username" />
      <TextField sx={{ fontSize: "18px"}} source="firstName" />
      <TextField sx={{ fontSize: "18px"}} source="firstName" />
    </SimpleShowLayout>
  </Show>
);
