import { Edit, required, SimpleForm, TextInput } from "react-admin";

export const EditPropertyOwner: React.FC = (props) => {
  return (
    <Edit {...props}>
      <SimpleForm>
        <TextInput source="firstName" validate={[required()]} />
        <TextInput source="lastName" validate={[required()]} />
      </SimpleForm>
    </Edit>
  );
};
