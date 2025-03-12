import { Create, required, SimpleForm, TextInput } from "react-admin";

export const CreatePropertyOwner: React.FC = (props) => {
    return (
      <Create { ...props }>
        <SimpleForm>
          <TextInput source="username" validate={[required()]} />
          <TextInput source="firstName" validate={[required()]} />
          <TextInput source="lastName" validate={[required()]} />
          <TextInput type="password" source="password" validate={[required()]} />
        </SimpleForm>
      </Create>
    );
  };