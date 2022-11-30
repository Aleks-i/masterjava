package ru.javaops.masterjava.xml.schema;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Projects">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="Project">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Groups">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                                       &lt;element name="Group">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                               &lt;attribute name="groupType" use="required">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;enumeration value="registering"/>
 *                                                     &lt;enumeration value="current"/>
 *                                                     &lt;enumeration value="finished"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="projectType" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="flag" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="active"/>
 *             &lt;enumeration value="deleted"/>
 *             &lt;enumeration value="superuser"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="city" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="email" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {"fullName", "projects"})
@XmlRootElement(name = "User", namespace = "http://javaops.ru")
public class User {

    @XmlElement(namespace = "http://javaops.ru", required = true)
    protected String fullName;
    @XmlElement(name = "Projects", namespace = "http://javaops.ru", required = true)
    protected User.Projects projects;
    @XmlAttribute(name = "flag", required = true)
    protected FlagType flag;
    @XmlAttribute(name = "city", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object city;
    @XmlAttribute(name = "email")
    protected String email;

    /**
     * Gets the value of the fullName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the projects property.
     *
     * @return possible object is
     * {@link User.Projects }
     */
    public User.Projects getProjects() {
        return projects;
    }

    /**
     * Sets the value of the projects property.
     *
     * @param value allowed object is
     *              {@link User.Projects }
     */
    public void setProjects(User.Projects value) {
        this.projects = value;
    }

    /**
     * Gets the value of the flag property.
     *
     * @return possible object is
     * {@link String }
     */
    public FlagType getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFlag(FlagType value) {
        this.flag = value;
    }

    /**
     * Gets the value of the city property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setCity(Object value) {
        this.city = value;
    }

    /**
     * Gets the value of the email property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmail(String value) {
        this.email = value;
    }

    @Override
    public String toString() {
        return "User{" + "fullName='" + fullName + '\'' + ", email='" + email + '\'' + ", city=" + city + ", flag=" + flag + ", projects=" + projects + '}';
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="Project">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Groups">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *                             &lt;element name="Group">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                     &lt;attribute name="groupType" use="required">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;enumeration value="registering"/>
     *                                           &lt;enumeration value="current"/>
     *                                           &lt;enumeration value="finished"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="projectType" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"project"})
    public static class Projects {

        @XmlElement(name = "Project", namespace = "http://javaops.ru")
        protected List<User.Projects.Project> project;

        /**
         * Gets the value of the project property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the project property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProject().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link User.Projects.Project }
         */
        public List<User.Projects.Project> getProject() {
            if (project == null) {
                project = new ArrayList<User.Projects.Project>();
            }
            return this.project;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Groups">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
         *                   &lt;element name="Group">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                           &lt;attribute name="groupType" use="required">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;enumeration value="registering"/>
         *                                 &lt;enumeration value="current"/>
         *                                 &lt;enumeration value="finished"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="projectType" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"groups"})
        public static class Project {

            @XmlElement(name = "Groups", namespace = "http://javaops.ru", required = true)
            protected User.Projects.Project.Groups groups;
            @XmlAttribute(name = "projectType", required = true)
            @XmlIDREF
            @XmlSchemaType(name = "IDREF")
            protected ProjectType projectType;

            /**
             * Gets the value of the groups property.
             *
             * @return possible object is
             * {@link User.Projects.Project.Groups }
             */
            public User.Projects.Project.Groups getGroups() {
                return groups;
            }

            /**
             * Sets the value of the groups property.
             *
             * @param value allowed object is
             *              {@link User.Projects.Project.Groups }
             */
            public void setGroups(User.Projects.Project.Groups value) {
                this.groups = value;
            }

            /**
             * Gets the value of the projectType property.
             *
             * @return possible object is
             * {@link Object }
             */
            public ProjectType getProjectType() {
                return projectType;
            }

            /**
             * Sets the value of the projectType property.
             *
             * @param value allowed object is
             *              {@link Object }
             */
            public void setProjectType(ProjectType value) {
                this.projectType = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
             *         &lt;element name="Group">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="groupType" use="required">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;enumeration value="registering"/>
             *                       &lt;enumeration value="current"/>
             *                       &lt;enumeration value="finished"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {"group"})
            public static class Groups {

                @XmlElement(name = "Group", namespace = "http://javaops.ru")
                protected List<User.Projects.Project.Groups.Group> group;

                /**
                 * Gets the value of the group property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the group property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getGroup().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link User.Projects.Project.Groups.Group }
                 */
                public List<User.Projects.Project.Groups.Group> getGroup() {
                    if (group == null) {
                        group = new ArrayList<User.Projects.Project.Groups.Group>();
                    }
                    return this.group;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 *
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *       &lt;attribute name="groupType" use="required">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;enumeration value="registering"/>
                 *             &lt;enumeration value="current"/>
                 *             &lt;enumeration value="finished"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {"value"})
                public static class Group {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "groupType", required = true)
                    protected String groupType;

                    /**
                     * Gets the value of the value property.
                     *
                     * @return possible object is
                     * {@link String }
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     *
                     * @param value allowed object is
                     *              {@link String }
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the groupType property.
                     *
                     * @return possible object is
                     * {@link String }
                     */
                    public String getGroupType() {
                        return groupType;
                    }

                    /**
                     * Sets the value of the groupType property.
                     *
                     * @param value allowed object is
                     *              {@link String }
                     */
                    public void setGroupType(String value) {
                        this.groupType = value;
                    }

                }

            }

            @Override
            public String toString() {
                return "Project{" + "groups=" + groups + ", projectType=" + projectType + '}';
            }
        }

        @Override
        public String toString() {
            return "Projects{" + "project=" + project + '}';
        }
    }

}
