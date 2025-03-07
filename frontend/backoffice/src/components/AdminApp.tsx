import { dataProvider } from "@/client/mock/privider";
import { Admin, EditGuesser, ListGuesser, Resource } from "react-admin";

const AdminApp = () => {
  type roleType = "admin" | "propertyOwner";
  const role: roleType = "admin";
  return (
    <Admin dataProvider={dataProvider}>
      {role === "admin" ? (
        <Resource
          name="users"
          list={ListGuesser}
          edit={EditGuesser}
        />
      ) : (
        <Resource
          name="posts"
          list={ListGuesser}
          edit={EditGuesser}
        />
      )}
    </Admin>
  );
};

export default AdminApp;
