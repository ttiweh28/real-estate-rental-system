import {
  Create,
  SimpleForm,
  TextInput,
  SelectInput,
  FileInput,
  FileField
} from "react-admin";
import {
  Grid,
  Card,
  CardContent,
  Typography,
  Box,
} from "@mui/material";

export const CreatePropertyOwner: React.FC = (props) => {
  return (
    <Create>
    <Card>
      <CardContent>
        <Typography variant="h6" gutterBottom>
          Create Property Owner
        </Typography>

        <SimpleForm>
          <Grid container spacing={3}>
            <Grid item xs={12} sm={6}>
              <TextInput source="firstName" label="First Name" fullWidth required />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="lastName" label="Last Name" fullWidth required />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="userName" label="Username" fullWidth required />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="email" label="Email" fullWidth type="email" required />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="phoneNumber" label="Phone Number" fullWidth />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="password" label="Password" fullWidth />
            </Grid>

            <Grid item xs={12} sm={6}>
              <FileInput source="photo" label="Avatar" fullWidth>
                <FileField source="src" title="title" />
              </FileInput>
            </Grid>

            <Grid item xs={12} sm={6}>
              <SelectInput
                source="role"
                label="Role"
                readOnly
                choices={[
                  { id: 'ROLE_ADMIN', name: "Admin" },
                  { id: 'ROLE_PROPERTIES_OWNER', name: "Property Owner" },
                ]}
                fullWidth
                defaultValue={"ROLE_PROPERTIES_OWNER"}
              />
            </Grid>

            <Grid item xs={12}>
              <Typography variant="h6" gutterBottom>
                Address Details
              </Typography>
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="address.street" label="Street" fullWidth />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="address.city" label="City" fullWidth />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="address.state" label="State" fullWidth />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="address.zipCode" label="Zip Code" fullWidth />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextInput source="address.country" label="Country" fullWidth />
            </Grid>
          </Grid>
        </SimpleForm>
      </CardContent>
    </Card>
  </Create>
  );
};
