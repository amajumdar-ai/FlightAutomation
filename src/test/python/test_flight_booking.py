import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.alert import Alert

# Initialize the WebDriver
@pytest.fixture(scope="module")
def driver():
    # Setup Chrome driver with the correct Service
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service)
    driver.maximize_window()
    yield driver
    driver.quit()

# Test case to book a flight
def test_flight_booking(driver):
    # Open the MakeMyTrip website
    driver.get("https://www.makemytrip.com/")
    
    # Wait for the page to load
    driver.implicitly_wait(10)

    # Close any popups (e.g., holiday sale image)
    try:
        close_popup_button = WebDriverWait(driver, 10).until(
            EC.element_to_be_clickable((By.XPATH, "//img[@alt='close']"))
        )
        close_popup_button.click()
    except:
        print("No popup found.")

    # Click on the 'Login' button
    login_button = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//span[text()='Login']"))
    )
    login_button.click()

    # Wait for the login modal to open
    WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.XPATH, "//input[@id='username']")))

    # Enter username (phone number or email)
    username_input = driver.find_element(By.XPATH, "//input[@id='username']")
    username_input.send_keys("abc")  # Replace with valid username (e.g., phone/email)

    # Enter password
    password_input = driver.find_element(By.XPATH, "//input[@id='password']")
    password_input.send_keys("abc")  # Replace with valid password

    # Click the login button
    login_submit_button = driver.find_element(By.XPATH, "//button[@type='submit']")
    login_submit_button.click()

    # Wait for the login to complete (adjust timing as necessary)
    WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.XPATH, "//span[text()='Hello']")))

    # Proceed with the flight booking process
    # Click on the 'Flights' option
    flights_button = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//span[text()='Flights']"))
    )
    # Use JavaScript to click the button if it's being intercepted
    driver.execute_script("arguments[0].click();", flights_button)

    # Select ROUND TRIP
    round_trip_option = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//li[@data-cy='roundTrip']"))
    )
    driver.execute_script("arguments[0].click();", round_trip_option)

    # Enter FROM location as HYD
    from_location_input = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//input[@id='fromCity']"))
    )
    driver.execute_script("arguments[0].scrollIntoView(true);", from_location_input)
    driver.execute_script("arguments[0].click();", from_location_input)

    from_location_input.clear()
    from_location_input.send_keys("HYD")
    driver.implicitly_wait(2)
    from_location_input.send_keys(Keys.ENTER)

    # Enter TO location as MAA
    to_location_input = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//input[@id='toCity']"))
    )
    to_location_input.click()
    to_location_input.clear()
    to_location_input.send_keys("MAA")
    driver.implicitly_wait(2)
    to_location_input.send_keys(Keys.ENTER)

    # Select Departure Date (example: "14th Feb")
    departure_date = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//div[@aria-label='Thu Feb 14 2025']"))
    )
    departure_date.click()

    # Select Return Date (example: "21st Feb")
    return_date = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//div[@aria-label='Thu Feb 21 2025']"))
    )
    return_date.click()

    # Click on the Search button
    search_button = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//a[@class='primaryBtn font24 latoBold widgetSearchBtn']"))
    )
    search_button.click()

    # Verify if the Search Results page is displayed
    assert "Search Results" in driver.title, "Search page not displayed"
