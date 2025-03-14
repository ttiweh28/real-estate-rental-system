import React, { useState, useEffect } from "react";
import { useRedirect, useNotify, useDataProvider, Edit, EditProps, useEditContext } from "react-admin";
import {
  Card,
  CardContent,
  Typography,
  TextField,
  Box,
  Grid,
  Stepper,
  Step,
  StepLabel,
  IconButton,
  Chip,
  InputAdornment,
  Button,
} from "@mui/material";
import { Plus, X } from "lucide-react";
import { T_PropertyEdit } from "@/types/property";

const steps = ["Property Details", "Upload Images", "Review & Submit"];

export const EditProperties = (props: EditProps) => {
  return (
    <Edit {...props}>
      <EditProperty />
    </Edit>
  );
};

export const EditProperty = () => {
  const { record, isLoading } = useEditContext();

  const redirect = useRedirect();
  const notify = useNotify();
  const dataProvider = useDataProvider();

  const [activeStep, setActiveStep] = useState(0);
  const [newAmenity, setNewAmenity] = useState("");
  const [formData, setFormData] = useState<T_PropertyEdit | null>(null);

  useEffect(() => {
    if (record) {
      setFormData({
        id: record.id,
        name: record.name,
        location: record.location,
        price: record.price,
        description: record.description,
        banner: record.banner,
        images: record.images || [],
        amenities: record.amenities || [],
      });
    }
  }, [record]);

  if (isLoading || !formData) return <Typography>Loading...</Typography>;

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData((prev) => (prev ? { ...prev, [name]: value } : prev));
  };

  const handleNext = () => setActiveStep((prev) => prev + 1);
  const handleBack = () => setActiveStep((prev) => prev - 1);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    // TODO: Upload only new images
    try {
      await dataProvider.update("properties", {
        id: formData.id,
        data: formData,
        previousData: record,
      });
      notify("Property updated successfully", { type: "success" });
      redirect("/properties");
    } catch (error) {
      notify(`Error updating property ${error}`, { type: "error" });
    }
  };

  const handleAddAmenity = () => {
    if (newAmenity.trim() && !formData.amenities.includes(newAmenity.trim())) {
      setFormData((prev) =>
        prev
          ? { ...prev, amenities: [...prev.amenities, newAmenity.trim()] }
          : prev
      );
      setNewAmenity("");
    }
  };

  const handleRemoveAmenity = (amenityToRemove: string) => {
    setFormData((prev) =>
      prev
        ? {
            ...prev,
            amenities: prev.amenities.filter(
              (amenity) => amenity !== amenityToRemove
            ),
          }
        : prev
    );
  };

  const isStepValid = () => {
    if (activeStep === 0) {
      return (
        formData.name &&
        formData.location &&
        formData.price &&
        formData.description &&
        formData.amenities.length > 0
      );
    }
    if (activeStep === 1) {
      return formData.images.length > 1;
    }
    return true;
  };

  return (
    <div style={{ width: "1200px", margin: 20 }}>
      <Stepper activeStep={activeStep} sx={{ mb: 3 }}>
        {steps.map((label) => (
          <Step key={label}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>

      <Card>
        <CardContent>
          {activeStep === 0 && (
            <Grid container spacing={3}>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  label="Property Title"
                  name="name"
                  value={formData.name}
                  onChange={handleInputChange}
                  required
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  fullWidth
                  label="Location"
                  name="location"
                  value={formData.location}
                  onChange={handleInputChange}
                  required
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  fullWidth
                  label="Price"
                  name="price"
                  type="number"
                  value={parseInt(formData.price)}
                  onChange={handleInputChange}
                  InputProps={{
                    startAdornment: (
                      <InputAdornment position="start">$</InputAdornment>
                    ),
                  }}
                  required
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  label="Description"
                  name="description"
                  value={formData.description}
                  onChange={handleInputChange}
                  multiline
                  rows={4}
                  required
                />
              </Grid>
              <Grid item xs={12}>
                <Typography variant="subtitle1" sx={{ mb: 1 }}>
                  Amenities
                </Typography>
                <Box sx={{ display: "flex", gap: 1, mb: 2 }}>
                  <TextField
                    size="small"
                    value={newAmenity}
                    onChange={(e) => setNewAmenity(e.target.value)}
                    placeholder="Add amenity"
                    onKeyUp={(e) => {
                      if (e.key === "Enter") handleAddAmenity();
                    }}
                  />
                  <Button
                    variant="contained"
                    onClick={handleAddAmenity}
                    startIcon={<Plus size={20} />}
                  >
                    Add
                  </Button>
                </Box>
                <Box sx={{ display: "flex", gap: 1, flexWrap: "wrap" }}>
                  {formData.amenities.map((amenity, index) => (
                    <Chip
                      key={index}
                      label={amenity}
                      onDelete={() => handleRemoveAmenity(amenity)}
                      deleteIcon={<X size={16} />}
                    />
                  ))}
                </Box>
              </Grid>
              <Box
                sx={{
                  display: "flex",
                  gap: 2,
                  justifyContent: "flex-end",
                  mt: 4,
                  ml: 3,
                }}
              >
                <Button onClick={handleNext}>Next</Button>
              </Box>
            </Grid>
          )}

          {activeStep === 1 && (
            <Grid container spacing={3}>
              <Grid item xs={12}>
                <Typography variant="h6">Upload House Images</Typography>
                <Box
                  sx={{ display: "flex", alignItems: "center", gap: 2, mt: 2 }}
                >
                  <label htmlFor="upload-images">
                    <Button component="span">
                      <div style={{ display: "flex", alignItems: "center" }}>
                        <Plus size={18} />
                        <span>Upload Images</span>
                      </div>
                    </Button>
                  </label>
                  <input
                    id="upload-images"
                    type="file"
                    multiple
                    accept="image/*"
                    hidden
                    onChange={(e) => {
                      const files = Array.from(e.target.files || []);
                      setFormData((prev) => {
                        if (!prev) return prev;
                        return {
                          ...prev,
                          images: [...prev.images, ...files],
                        };
                      });
                    }}
                  />
                </Box>
              </Grid>

              <Grid item xs={12}>
                <Box sx={{ display: "flex", gap: 2, flexWrap: "wrap", mt: 2 }}>
                  {formData.images.map((file, index) => {
                    return (
                      <Box
                        key={index}
                        sx={{
                          position: "relative",
                          width: "120px",
                          height: "120px",
                          borderRadius: "8px",
                          overflow: "hidden",
                          border: "2px solid #ddd",
                          display: "flex",
                          alignItems: "center",
                          justifyContent: "center",
                          cursor: "pointer",
                        }}
                      >
                        <img
                          src={
                            file instanceof File
                              ? URL.createObjectURL(file)
                              : file
                          }
                          alt={`Preview ${index + 1}`}
                          style={{
                            maxWidth: "100%",
                            maxHeight: "100%",
                            objectFit: "cover",
                          }}
                        />
                        <IconButton
                          sx={{
                            position: "absolute",
                            top: -8,
                            right: -8,
                            background: "#f00",
                            color: "#fff",
                          }}
                          onClick={(e) => {
                            e.stopPropagation();

                            if (file instanceof File) {
                              setFormData((prev) => {
                                if (!prev) return prev;
                                return {
                                  ...prev,
                                  images: prev.images.filter(
                                    (_, i) => i !== index
                                  ),
                                };
                              });
                            } else {
                              alert("Delete from database");
                            }
                          }}
                        >
                          <X size={14} />
                        </IconButton>
                      </Box>
                    );
                  })}
                </Box>
              </Grid>
              <Grid item xs={12}>
                <Button onClick={handleBack} sx={{ mr: 3 }}>
                  <span>Back</span>
                </Button>

                <Button onClick={handleNext} disabled={!isStepValid()}>
                  <span>Next</span>
                </Button>
              </Grid>
            </Grid>
          )}

          {activeStep === 2 && (
            <Grid container spacing={3}>
              <Grid item xs={12}>
                <Typography variant="h6">Review & Submit</Typography>
                <Typography>
                  <strong>Title:</strong> {formData.name}
                </Typography>
                <Typography>
                  <strong>Description:</strong> {formData.description}
                </Typography>
                <Typography>
                  <strong>Price:</strong> {formData.price}
                </Typography>
                <Typography>
                  <strong>Location:</strong> {formData.location}
                </Typography>
                <Typography>
                  <strong>Amenities:</strong> {formData.amenities.join(", ")}
                </Typography>
                <Typography>
                  <strong>Uploaded Images:</strong>
                </Typography>
                <Box sx={{ display: "flex", gap: 2, flexWrap: "wrap", mt: 2 }}>
                  {formData.images.map((file, index) => {
                    return (
                      <img
                        key={index}
                        src={
                          file instanceof File
                            ? URL.createObjectURL(file)
                            : file
                        }
                        alt={`Review ${index + 1}`}
                        style={{
                          width: "100px",
                          height: "100px",
                          objectFit: "cover",
                          borderRadius: "8px",
                        }}
                      />
                    );
                  })}
                </Box>
              </Grid>
              <Box
                sx={{
                  display: "flex",
                  gap: 2,
                  justifyContent: "space-between",
                  mt: 4,
                  ml: 3,
                }}
              >
                <Button onClick={handleBack}>Back</Button>
                <Button
                  type="submit"
                  variant="contained"
                  color="primary"
                  onClick={handleSubmit}
                >
                  Update
                </Button>
              </Box>
            </Grid>
          )}
        </CardContent>
      </Card>
    </div>
  );
};

export default EditProperty;
