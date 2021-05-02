class Class_Data:
    def __init__(self, package_name, class_name, fields):
        self.package_name = package_name
        self.class_name = class_name
        self.fields = fields


def get_data_from_entity_file():
    with open("./input/Reservation.java", "r") as file:
        entity_file = file.readlines()
    package_name = ""
    class_name = ""
    fields = []
    for line in entity_file:
        line = line.lstrip()
        if line.startswith("package"):
            package = line.partition("package ")[2]
            package_name = line.partition("entity")[0]

        if line.startswith("public class "):
            class_name = line.partition("public class ")[2]
            class_name = class_name.rstrip(" {\n")

        if line.startswith("private"):
            field = line.rstrip()[:-1].split(" ")
            field_name = field[1]
            field_type = field[2]
            fields.append((field_name, field_type))

    class_data = Class_Data(package_name, class_name, fields)
    return class_data



def generateDao(class_data):
    capitalized_class_name = class_data.class_name
    class_name = capitalized_class_name.lower()
    first_letter_var = capitalized_class_name[0]
    update_values = generate_update_fields(class_name, class_data.fields)

    with open("dao_template.java", "r") as file:
        dao_template = file.read()
    print(dao_template)

    output_text = dao_template.format(
        capitalized_name=capitalized_class_name, small_letter_name=class_name,
        first_letter=first_letter_var, update=update_values)
    output_filename = capitalized_class_name + "Dao.java"
    with open(output_filename, "w") as f:
        f.write(output_text)


def generate_update_fields(class_name, fields):
    update = ""
    for (type, name) in fields:
        name = name[0].capitalize() + name[1:]
        template = f"        {class_name}ToChange.set{name}({class_name}.get{name}());"
        update += template + "\n"
    return update.rstrip()


class_data = get_data_from_entity_file()
generateDao(class_data)
