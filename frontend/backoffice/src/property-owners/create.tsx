import {
  Create,
  ImageField,
  ImageInput,
  required,
  SimpleForm,
  TextInput,
} from "react-admin";

export const CreatePropertyOwner: React.FC = (props) => {
  return (
    <Create {...props}>
      <SimpleForm>
        <ImageInput
          source="avatar"
          label="Avatar"
          accept={{ "image/*": [".png", ".jpg"] }}
        >
          <ImageField source="src" title="title" />
        </ImageInput>
        <TextInput source="username" validate={[required()]} />
        <TextInput source="firstName" validate={[required()]} />
        <TextInput source="lastName" validate={[required()]} />
        <TextInput type="password" source="password" validate={[required()]} />
      </SimpleForm>
    </Create>
  );
};
