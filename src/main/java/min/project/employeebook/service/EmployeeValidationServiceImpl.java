package min.project.employeebook.service;

import min.project.employeebook.exception.InvalidEmployeeDataException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService{
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    public void validateName(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new InvalidEmployeeDataException("Некорректное имя: " + name);
        }
    }

}
