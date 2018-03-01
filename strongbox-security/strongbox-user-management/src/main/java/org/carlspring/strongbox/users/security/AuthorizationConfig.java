package org.carlspring.strongbox.users.security;

import org.carlspring.strongbox.data.domain.GenericEntity;
import org.carlspring.strongbox.security.Roles;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

/**
 * Java representation for authorization config that stored in XML file.
 *
 * @author Alex Oreshkevich
 * @see /src/main/resources/etc/conf/strongbox-authorization.xml
 * @see {@linkplain https://dev.carlspring.org/youtrack/issue/SB-126}
 */
@XmlRootElement(name = "authorization-configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorizationConfig
        extends GenericEntity
{

    @XmlElement
    @Embedded
    private Roles roles;

    public Roles getRoles()
    {
        return roles;
    }

    public void setRoles(Roles roles)
    {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizationConfig that = (AuthorizationConfig) o;
        return Objects.equal(roles, that.roles);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(roles);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AuthorizationConfig{");
        sb.append("roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
