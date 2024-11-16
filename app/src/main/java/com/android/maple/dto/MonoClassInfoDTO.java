package com.android.maple.dto;

import androidx.annotation.Nullable;

public class MonoClassInfoDTO extends MonoObjectInfoDTO {
    @Nullable
    public String Namespace;

    @Nullable
    public byte[] Utf8Namespace;

    public int Flags;
    public Boolean IsEnum;
    public Boolean IsValueType;
    public Boolean IsGeneric;
    public Boolean IsInterface;

    public Boolean IsStatic;
    public Boolean IsAbstract;
    //public bool IsSystem { set; get; }
    //public bool IsUnity { set; get; }

    public int Size;
    public int TypeToken;

    @Nullable
    public String ImageName;

    @Nullable
    public byte[] Utf8ImageName;

    // public string? ImageFile { set; get; }

    public int TypeEnum;

    @Nullable
    public String TypeName;

    //public string? ToDisplayName()
    //{
    //    if (string.IsNullOrEmpty(this.Namespace))
    //    {
    //        return $@"{this.Name}";
    //    }
    //    return $@"{this.Namespace}.{this.Name}";

    //}
    //     [JsonIgnore]
    //  public string? FullName => TypeName;

    //       [JsonIgnore]
//    public bool IsRefType => !IsValueType && !IsInterface;
}
