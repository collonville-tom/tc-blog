from setuptools import setup, find_packages
setup(
    name="people_stat",
    version="0.1.0",
    packages=find_packages(),
    scripts=['people_stat.py', 'json_tk.py', 'human.py', 'response.py'],
    install_requires=['docutils>=0.3', 'Flask>=1.1.1', 'python-http-client>=3.1.0']
)