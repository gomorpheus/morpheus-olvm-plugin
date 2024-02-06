/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.api.metamodel.runtime.util.ArrayListWithHref;
import org.ovirt.api.metamodel.runtime.util.ListWithHref;
import org.ovirt.api.metamodel.runtime.util.UnmodifiableListWithHref;

public class Container {
    protected static Byte asByte(String type, String member, BigInteger value) {
        if (value == null) {
            return null;
        }
        try {
            return value.byteValueExact();
        }
        catch (ArithmeticException excetion) {
            throw new ArithmeticException(
            "The integer value " + value + " of the '" + member + "' member of " +
            "type '" + type + "' can't be converted to a 8 bits integer because that " +
            "would loss precision."
            );
        }
    }
    
    protected static Short asShort(String type, String member, BigInteger value) {
        if (value == null) {
            return null;
        }
        try {
            return value.shortValueExact();
        }
        catch (ArithmeticException exception) {
            throw new ArithmeticException(
            "The integer value " + value + " of the '" + member + "' member of " +
            "type '" + type + "' can't be converted to a 16 bits integer because that " +
            "would loss precision."
            );
        }
    }
    
    protected static Integer asInteger(String type, String member, BigInteger value) {
        if (value == null) {
            return null;
        }
        try {
            return value.intValueExact();
        }
        catch (ArithmeticException exception) {
            throw new ArithmeticException(
            "The integer value " + value + " of the '" + member + "' member of " +
            "type '" + type + "' can't be converted to a 32 bits integer because that " +
            "would loss precision."
            );
        }
    }
    
    protected static Long asLong(String type, String member, BigInteger value) {
        if (value == null) {
            return null;
        }
        try {
            return value.longValueExact();
        }
        catch (ArithmeticException exception) {
            throw new ArithmeticException(
            "The integer value " + value + " of the '" + member + "' member of " +
            "type '" + type + "' can't be converted to a 64 bits integer because that " +
            "would loss precision."
            );
        }
    }
    
    protected static <E> List<E> makeUnmodifiableList(List<E> original) {
        if (original == null) {
            return Collections.emptyList();
        }
        else {
            if (original instanceof ListWithHref) {
                return new UnmodifiableListWithHref((ListWithHref) original);
            }
            return Collections.unmodifiableList(original);
        }
    }
    
    protected static <E> List<E> makeArrayList(List<E> original) {
        if (original == null) {
            return Collections.emptyList();
        }
        else {
            if (original instanceof ListWithHref) {
                return new ArrayListWithHref<E>((ListWithHref) original);
            }
            return new ArrayList<E>(original);
        }
    }
}
