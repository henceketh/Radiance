package com.radiance.client.texture;

import java.io.FilterInputStream;
import java.io.InputStream;
import net.minecraft.resources.ResourceLocation;

/**
 * Tags a resource stream with its id. Everything else, including {@code available()}, bulk reads and
 * {@code close()}, goes to the wrapped stream: loaders such as ModernFix's dynamic resources treat
 * {@code available() == 0} as an empty file.
 */
public class IdentifierInputStream extends FilterInputStream {

    private final ResourceLocation resourceId;

    public IdentifierInputStream(InputStream originalStream, ResourceLocation id) {
        super(originalStream);
        this.resourceId = id;
    }

    public ResourceLocation getResourceId() {
        return this.resourceId;
    }
}
