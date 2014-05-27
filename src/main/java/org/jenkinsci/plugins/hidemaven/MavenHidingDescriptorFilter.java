package org.jenkinsci.plugins.hidemaven;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.DescriptorVisibilityFilter;

@Extension
public class MavenHidingDescriptorFilter extends DescriptorVisibilityFilter {

    public static boolean DISABLE = false;

    // return true to allow
    @Override
    public boolean filter(Object context, Descriptor descriptor) {
        if (DISABLE) {
            return true;
        }
        if (descriptor.getId() != null && descriptor.getId().equals("hudson.maven.MavenModuleSet")) {
            return false;
        }
        return true;
    }
}
