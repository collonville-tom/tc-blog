from setuptools import setup, find_packages
setup(
    name="people",
    version="0.1.0",
    packages=find_packages(),
    scripts=['people.py','json_tk.py','human.py'],
    install_requires=['docutils>=0.3','Flask>=1.1.1']
)