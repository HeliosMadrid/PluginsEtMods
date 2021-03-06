
package fr.helios.astral.utils;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCoffreAstral extends ModelBase
{
    public ModelRenderer downPlate;
    public ModelRenderer rightPlate;
    public ModelRenderer frontPlate;
    public ModelRenderer leftPlate;
    public ModelRenderer backPlate;
    public ModelRenderer verrouePlate;
    public ModelRenderer serrurePlate;
    public ModelRenderer upPlate;
  
  public ModelCoffreAstral()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      downPlate = new ModelRenderer(this, 31, 33);
      downPlate.addBox(0F, 0F, 0F, 15, 1, 15);
      downPlate.setRotationPoint(-8F, 22F, -8F);
      downPlate.setTextureSize(128, 128);
      downPlate.mirror = true;
      setRotation(downPlate, 0F, 0F, 0F);
      rightPlate = new ModelRenderer(this, 0, 73);
      rightPlate.addBox(0F, 0F, 0F, 1, 13, 15);
      rightPlate.setRotationPoint(-8F, 9F, -8F);
      rightPlate.setTextureSize(128, 128);
      rightPlate.mirror = true;
      setRotation(rightPlate, 0F, 0F, 0F);
      frontPlate = new ModelRenderer(this, 0, 48);
      frontPlate.addBox(0F, 0F, 0F, 13, 13, 1);
      frontPlate.setRotationPoint(-7F, 9F, -8F);
      frontPlate.setTextureSize(128, 128);
      frontPlate.mirror = true;
      setRotation(frontPlate, 0F, 0F, 0F);
      leftPlate = new ModelRenderer(this, 45, 65);
      leftPlate.addBox(0F, 0F, 0F, 1, 13, 14);
      leftPlate.setRotationPoint(6F, 9F, -8F);
      leftPlate.setTextureSize(128, 128);
      leftPlate.mirror = true;
      setRotation(leftPlate, 0F, 0F, 0F);
      backPlate = new ModelRenderer(this, 3, 6);
      backPlate.addBox(0F, 0F, 0F, 14, 13, 1);
      backPlate.setRotationPoint(-7F, 9F, 6F);
      backPlate.setTextureSize(128, 128);
      backPlate.mirror = true;
      setRotation(backPlate, 0F, 0F, 0F);
      verrouePlate = new ModelRenderer(this, 0, 34);
      verrouePlate.addBox(-2.5F, 0F, -16F, 5, 5, 1);
      verrouePlate.setRotationPoint(-0.2666667F, 8F, 7F);
      verrouePlate.setTextureSize(128, 128);
      verrouePlate.mirror = true;
      setRotation(verrouePlate, 0F, 0F, 0F);
      serrurePlate = new ModelRenderer(this, 0, 29);
      serrurePlate.addBox(-0.2F, 0F, -17F, 1, 3, 1);
      serrurePlate.setRotationPoint(-0.5F, 8F, 7F);
      serrurePlate.setTextureSize(128, 128);
      serrurePlate.mirror = true;
      setRotation(serrurePlate, 0.2094395F, 0F, 0.0174533F);
      upPlate = new ModelRenderer(this, 45, 8);
      upPlate.addBox(-7.5F, 0F, -15F, 15, 1, 15);
      upPlate.setRotationPoint(-0.5F, 8F, 7F);
      upPlate.setTextureSize(128, 128);
      upPlate.mirror = true;
      setRotation(upPlate, 0F, 0F, 0F);
  }
  
  public void renderAll()
  {
    downPlate.render(0.0625F);
    rightPlate.render(0.0625F);
    frontPlate.render(0.0625F);
    leftPlate.render(0.0625F);
    backPlate.render(0.0625F);
    verrouePlate.render(0.0625F);
    serrurePlate.render(0.0625F);
    upPlate.render(0.0625F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
