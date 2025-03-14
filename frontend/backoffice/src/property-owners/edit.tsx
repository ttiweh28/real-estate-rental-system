import {
  Edit,
  ImageField,
  ImageInput,
  required,
  SimpleForm,
  TextInput,
} from "react-admin";

export const EditPropertyOwner: React.FC = (props) => {
  return (
    <Edit {...props}>
      <SimpleForm>
        <ImageInput
          source="avatar"
          label="Avatar"
          accept={{ "image/*": [".png", ".jpg"] }}
        >
          <ImageField source="src" title="title" />
        </ImageInput>
        <TextInput source="username" readOnly />
        <TextInput source="firstName" validate={[required()]} />
        <TextInput source="lastName" validate={[required()]} />
      </SimpleForm>
    </Edit>
  );
};
